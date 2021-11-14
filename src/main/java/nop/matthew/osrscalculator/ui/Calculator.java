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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Calculator extends JFrame {
	private final JPanel contentPane;
	private final BorderLayout mainLayout;
	private final SelectionPanel selectionPanel;
	private final ResultPanel resultPanel;

	public Calculator() {
		super("OSRS Calculator");
		this.mainLayout = new BorderLayout(0, 0);
		this.contentPane = new JPanel(mainLayout);
		setLayout(this.mainLayout);
		setContentPane(contentPane);
		setResizable(true);
		setMinimumSize(getMinimumSize());
		JFrame.setDefaultLookAndFeelDecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.selectionPanel = new SelectionPanel();
		this.resultPanel = new ResultPanel();
	}

	public void setup(int width, int height, Skills defaultSkill) {
		// Set up the selection panel
		contentPane.add(BorderLayout.NORTH, this.selectionPanel);
		this.selectionPanel.setup();
		JComboBox<String> selectedMethod = this.selectionPanel.getSelectedMethod();
		selectedMethod.addActionListener(e -> {
			Object selected = selectedMethod.getSelectedItem();
			if (selected != null)
				this.resultPanel.setMethod(Methods.getFromName(selected.toString()));
			repaint();
			revalidate();
		});

		// Set up the results panel
		contentPane.add(BorderLayout.CENTER, this.resultPanel);
		selectSkill(defaultSkill);

		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent componentEvent) {
				pack();
			}
		});
		setSize(width, height);
		validate();
		setVisible(true);
	}

	/** Add a skill to the results panel
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
				.read(getClass().getResource("/SkillIcons/" + key.toString().toLowerCase() + ".png"))
				.getScaledInstance(OSRSCalculator.SKILL_ICON_LENGTH, OSRSCalculator.SKILL_ICON_LENGTH, Image.SCALE_DEFAULT)));
		button.setToolTipText(key.toString());
		button.addActionListener(e -> selectSkill(key));
		this.selectionPanel.addButton(button);
	}

	private void selectSkill(Skills skills) {
		System.out.println("Selected calculator panel for " + skills);
		this.resultPanel.setActiveSkills(skills);
		this.selectionPanel.setMethods(Arrays.stream(Methods.values()).filter(m -> m.getSkill().equals(skills)).collect(Collectors.toList()));
		pack();
		repaint();
		revalidate();
	}

	@Override
	public Dimension getPreferredSize() {
		Insets insets = getInsets();
		return new Dimension(
				Math.max(getWidth(), OSRSCalculator.MINIMUM_WIDTH + insets.right + insets.left),
				Math.max(getHeight(), OSRSCalculator.MINIMUM_HEIGHT + insets.top + insets.bottom));
	}

	@Override
	public Dimension getMinimumSize() {
		Insets insets = getInsets();
		return new Dimension(
				OSRSCalculator.MINIMUM_WIDTH + insets.right + insets.left,
				OSRSCalculator.MINIMUM_HEIGHT + insets.top + insets.bottom);
	}
}
