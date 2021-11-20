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

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Calculator extends JFrame {
	private final JPanel contentPane;
	private static final JMenuBar menuBar = new JMenuBar();
	private static final SelectionPanel selectionPanel = new SelectionPanel();
	private static final ResultPanel resultPanel = new ResultPanel();
	private static SortCriteria sortCriteria;
	private static boolean goalIsLevel;

	public Calculator() {
		super("OSRS Calculator");
		LayoutManager layoutManager = new BorderLayout(0, 0);
		contentPane = new JPanel(layoutManager);
		setLayout(layoutManager);
		setContentPane(contentPane);
		setResizable(true);
		setMinimumSize(getMinimumSize());
		JFrame.setDefaultLookAndFeelDecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sortCriteria = OSRSCalculator.DEFAULT_SORTCRITERIA;
		goalIsLevel = OSRSCalculator.GOAL_IS_LEVEL_DEFAULT;

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent componentEvent) {
				resultPanel.getCurrentPanel().revalidate();
				pack();
			}
		});
	}

	public void openSwing(int width, int height) {
		// Set up the menu bar
		// Sorting
		JMenu sort = new JMenu("Sort");
		ButtonGroup sortGroup = new ButtonGroup();
		JRadioButtonMenuItem levelSort = new JRadioButtonMenuItem(SortCriteria.LEVEL.toString(), true);
		levelSort.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED)
				sortRecipes(SortCriteria.LEVEL);
		});
		sortGroup.add(levelSort);
		sort.add(levelSort);
		JRadioButtonMenuItem normalisedCostSort = new JRadioButtonMenuItem(SortCriteria.NORMALISED_COST.toString());
		normalisedCostSort.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED)
				sortRecipes(SortCriteria.NORMALISED_COST);
		});
		sortGroup.add(normalisedCostSort);
		sort.add(normalisedCostSort);
		JRadioButtonMenuItem profitSort = new JRadioButtonMenuItem(SortCriteria.PROFIT.toString());
		profitSort.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED)
				sortRecipes(SortCriteria.PROFIT);
		});
		sortGroup.add(profitSort);
		sort.add(profitSort);
		JRadioButtonMenuItem nameSort = new JRadioButtonMenuItem(SortCriteria.NAME.toString());
		nameSort.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED)
				sortRecipes(SortCriteria.NAME);
		});
		sortGroup.add(nameSort);
		sort.add(nameSort);
		menuBar.add(sort);

		// Goals
		JMenu goals = new JMenu("Goals");
		ButtonGroup goalTypeGroup = new ButtonGroup();
		JRadioButtonMenuItem goalTypeLevel = new JRadioButtonMenuItem("Level", true);
		goalTypeLevel.addItemListener(e -> goalIsLevel = (e.getStateChange() == ItemEvent.SELECTED));
		goalTypeGroup.add(goalTypeLevel);
		goals.add(goalTypeLevel);
		JRadioButtonMenuItem goalTypeXp = new JRadioButtonMenuItem("XP", false);
		goalTypeXp.addItemListener(e -> goalIsLevel = (e.getStateChange() != ItemEvent.SELECTED));
		goalTypeGroup.add(goalTypeXp);
		goals.add(goalTypeXp);
		menuBar.add(goals);

		setJMenuBar(menuBar);

		// Set up the selection panel
		contentPane.add(BorderLayout.NORTH, selectionPanel);


		// Set up the results panel
		contentPane.add(BorderLayout.CENTER, resultPanel);
		selectSkill(OSRSCalculator.DEFAULT_SKILL);
		sortRecipes(SortCriteria.LEVEL);

		setSize(width, height);
		setLocationRelativeTo(null);
		validate();
		repaint();
		pack();
		setMinimumSize(this.getLayout().minimumLayoutSize(this));
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
		resultPanel.add(panel);

		// Create a JButton with the given skill's image to swap to it
		JButton button = new JButton(new ImageIcon(ImageIO
				.read(skill.getIconPath())
				.getScaledInstance(OSRSCalculator.SKILL_ICON_LENGTH, OSRSCalculator.SKILL_ICON_LENGTH, Image.SCALE_DEFAULT)));
		button.setToolTipText(key.toString());
		button.addActionListener(e -> selectSkill(key));
		SelectionPanel.addSkillButton(button);
	}

	private void selectSkill(Skills skills) {
		System.out.println("Selected calculator panel for " + skills);
		resultPanel.setActiveSkills(skills);
		SelectionPanel.setMethods(Arrays.stream(Methods.values()).filter(m -> m.getSkill().equals(skills)).collect(Collectors.toList()));
		resultPanel.sortBy(sortCriteria);
		pack();
		repaint();
		revalidate();
	}

	private void sortRecipes(SortCriteria criteria) {
		sortCriteria = criteria;
		resultPanel.sortBy(criteria);
	}

	public static SelectionPanel getSelectionPanel() {
		return selectionPanel;
	}

	public static ResultPanel getResultPanel() {
		return resultPanel;
	}

	public static SortCriteria getSortCriteria() {
		return sortCriteria;
	}

	public static boolean goalIsLevel() {
		return goalIsLevel;
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension min = getMinimumSize();
		return new Dimension(Math.max(getWidth(), min.width), Math.max(getHeight(), min.height));
	}
}
