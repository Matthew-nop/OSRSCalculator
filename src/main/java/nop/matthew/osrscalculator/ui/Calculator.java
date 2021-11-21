/*
 * Copyright 2021 Matthew C. <Chapman.L.Matthew@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nop.matthew.osrscalculator.ui;

import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;
import nop.matthew.osrscalculator.data.SortCriteria;
import nop.matthew.osrscalculator.net.PriceFetcher;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Calculator extends JFrame {
	private static final Calculator calculator = new Calculator();
	private final JPanel contentPane = new JPanel(new BorderLayout(0, 0));
	private final JMenuBar menuBar = new JMenuBar();
	private final ResultPanel resultPanel;
	private final SelectionPanel selectionPanel;
	private final Object autoUpdatePricesLock = new Object();
	private final Object lastPriceUpdateLock = new Object();
	private SortCriteria sortCriteria;
	private boolean goalIsLevel;
	private Thread priceFetcherThread;
	private boolean autoUpdatePrices;
	private long lastPriceUpdate;

	private Calculator() {
		super("OSRS Calculator");
		setContentPane(contentPane);
		setResizable(true);
		setMinimumSize(getMinimumSize());
		JFrame.setDefaultLookAndFeelDecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.sortCriteria = OSRSCalculator.DEFAULT_SORTCRITERIA;
		this.goalIsLevel = OSRSCalculator.GOAL_IS_LEVEL_DEFAULT;
		this.autoUpdatePrices = OSRSCalculator.AUTOUPDATE_PRICES_DEFAULT;
		this.selectionPanel = SelectionPanel.getInstance();
		this.resultPanel = ResultPanel.getInstance();

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent componentEvent) {
				resultPanel.getCurrentPanel().revalidate();
				pack();
			}
		});
	}

	public static Calculator getInstance() {
		return calculator;
	}

	public void start(int width, int height) {
		// Set up the menu bar
		// Sorting
		JMenu sort = new JMenu("Sort");
		ButtonGroup sortGroup = new ButtonGroup();
		JRadioButtonMenuItem levelSort, normalisedCostSort, profitSort, nameSort;
		levelSort = new JRadioButtonMenuItem(SortCriteria.LEVEL.toString(), sortCriteria.equals(SortCriteria.LEVEL));
		levelSort.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				sortRecipes(SortCriteria.LEVEL);
			}
		});
		sortGroup.add(levelSort);
		sort.add(levelSort);
		normalisedCostSort = new JRadioButtonMenuItem(SortCriteria.NORMALISED_COST.toString(), sortCriteria.equals(SortCriteria.NORMALISED_COST));
		normalisedCostSort.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				sortRecipes(SortCriteria.NORMALISED_COST);
			}
		});
		sortGroup.add(normalisedCostSort);
		sort.add(normalisedCostSort);
		profitSort = new JRadioButtonMenuItem(SortCriteria.PROFIT.toString(), sortCriteria.equals(SortCriteria.PROFIT));
		profitSort.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				sortRecipes(SortCriteria.PROFIT);
			}
		});
		sortGroup.add(profitSort);
		sort.add(profitSort);
		nameSort = new JRadioButtonMenuItem(SortCriteria.NAME.toString(), sortCriteria.equals(SortCriteria.NAME));
		nameSort.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				sortRecipes(SortCriteria.NAME);
			}
		});
		sortGroup.add(nameSort);
		sort.add(nameSort);
		this.menuBar.add(sort);

		// Prices
		JMenu prices = new JMenu("Prices");
		JMenuItem updatePrices = new JMenuItem("Update now");
		updatePrices.addActionListener(e -> {
			try {
				updatePriceFetcher();
			} catch (IOException ignored) {
			}
		});
		prices.add(updatePrices);
		JCheckBoxMenuItem autoUpdateCheckbox = new JCheckBoxMenuItem("AutoUpdate", this.autoUpdatePrices);
		autoUpdateCheckbox.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				startPriceAutoUpdate();
			}
			else if (e.getStateChange() == ItemEvent.DESELECTED) {
				stopPriceAutoUpdate();
			}
		});
		prices.add(autoUpdateCheckbox);
		this.menuBar.add(prices);

		// Goals
		JMenu goals = new JMenu("Goals");
		ButtonGroup goalTypeGroup = new ButtonGroup();
		JRadioButtonMenuItem goalTypeLevel = new JRadioButtonMenuItem("Level", this.goalIsLevel);
		goalTypeLevel.addItemListener(e -> this.goalIsLevel = (e.getStateChange() == ItemEvent.SELECTED));
		goalTypeGroup.add(goalTypeLevel);
		goals.add(goalTypeLevel);
		JRadioButtonMenuItem goalTypeXp = new JRadioButtonMenuItem("XP", this.goalIsLevel);
		goalTypeXp.addItemListener(e -> this.goalIsLevel = (e.getStateChange() != ItemEvent.SELECTED));
		goalTypeGroup.add(goalTypeXp);
		goals.add(goalTypeXp);
		this.menuBar.add(goals);

		setJMenuBar(this.menuBar);

		// Set up the results panel
		this.contentPane.add(BorderLayout.CENTER, this.resultPanel);
		selectSkill(OSRSCalculator.DEFAULT_SKILL);
		sortRecipes(SortCriteria.LEVEL);

		// Set up the selection panel
		this.selectionPanel.setup();
		this.contentPane.add(BorderLayout.NORTH, this.selectionPanel);

		if (this.autoUpdatePrices) {
			startPriceAutoUpdate();
		}

		setSize(width, height);
		setLocationRelativeTo(null);
		validate();
		repaint();
		pack();
		setMinimumSize(this.getLayout().minimumLayoutSize(this));
		System.gc();
		setVisible(true);
	}

	/**
	 * Add a skill to the results panel
	 *
	 * @param skill the skill to add
	 * @throws IOException if the image fails to read
	 */
	public void addSkill(Skill skill) throws IOException {
		Skills key = skill.getKey();
		SkillPanel panel = new SkillPanel(skill);
		this.resultPanel.add(panel);

		// Create a JButton with the given skill's image to swap to it
		JButton button = new JButton(new ImageIcon(ImageIO
				.read(skill.getIconPath())
				.getScaledInstance(OSRSCalculator.SKILL_ICON_LENGTH, OSRSCalculator.SKILL_ICON_LENGTH, Image.SCALE_SMOOTH)));
		button.setToolTipText(key.toString());
		button.addActionListener(e -> selectSkill(key));
		this.selectionPanel.addSkillButton(button);
	}

	private void selectSkill(Skills skills) {
		System.out.println("Selected calculator panel for " + skills);
		this.resultPanel.setActiveSkills(skills);
		this.selectionPanel.setMethods(Arrays.stream(Methods.values()).filter(m -> m.getSkill().equals(skills)).collect(Collectors.toList()));
		this.resultPanel.sortBy(sortCriteria);
		pack();
		repaint();
		revalidate();
	}

	private void sortRecipes(SortCriteria criteria) {
		this.sortCriteria = criteria;
		this.resultPanel.sortBy(criteria);
	}

	private void startPriceAutoUpdate() {
		synchronized (this.autoUpdatePricesLock) {
			this.autoUpdatePrices = true;
		}
		this.priceFetcherThread = new Thread(() -> {
			System.out.println("PriceFetcher AutoUpdate thread started.");
			boolean autoUpdate = true;
			while (autoUpdate) {
				try {
					long wait = this.lastPriceUpdate + OSRSCalculator.AUTOUPDATE_WAIT_MS - System.currentTimeMillis();
					if (wait > 0) {
						Thread.sleep(wait);
					}
					updatePriceFetcher();
					System.out.println("Auto updated prices with system time: " + this.lastPriceUpdate);
					SwingUtilities.invokeLater(() -> ResultPanel.getInstance().updateCosts());
					// If the sorting is affected by cost, re-sort the result panel
					switch (this.sortCriteria) {
						case LEVEL:
						case NAME:
							break;
						case PROFIT:
						case NORMALISED_COST:
							SwingUtilities.invokeLater(() -> ResultPanel.getInstance().sortBy(this.sortCriteria));
							break;
					}
				} catch (InterruptedException | IOException e) {
					synchronized (this.autoUpdatePricesLock) {
						autoUpdate = this.autoUpdatePrices;
					}
				}
			}
			System.out.println("PriceFetcher AutoUpdate thread stopped.");
		});
		this.priceFetcherThread.start();
	}

	private void stopPriceAutoUpdate() {
		synchronized (this.autoUpdatePricesLock) {
			this.autoUpdatePrices = false;
		}
		this.priceFetcherThread.interrupt();
	}

	private void updatePriceFetcher() throws IOException {
		PriceFetcher.updatePrices();
		synchronized (this.lastPriceUpdateLock) {
			this.lastPriceUpdate = System.currentTimeMillis();
		}
	}

	public SortCriteria getSortCriteria() {
		return this.sortCriteria;
	}

	public boolean goalIsLevel() {
		return this.goalIsLevel;
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension min = getMinimumSize();
		return new Dimension(Math.max(getWidth(), min.width), Math.max(getHeight(), min.height));
	}
}
