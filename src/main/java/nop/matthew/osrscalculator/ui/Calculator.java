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
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Calculator extends JFrame{
	private final BorderLayout mainLayout;
	private final SelectionPanel selectionPanel;
	private final ResultPanel resultPanel;

	public Calculator() {
		super("OSRS Calculator");
		this.mainLayout = new BorderLayout(0, 0);
		setLayout(mainLayout);
		setResizable(true);
		JFrame.setDefaultLookAndFeelDecorated(false);
		setLocationRelativeTo(null);
		this.selectionPanel = new SelectionPanel();
		this.resultPanel = new ResultPanel();
	}

	public void setup(Skills defaultSkill) {
		// Set up the main frame
		setLayout(this.mainLayout);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the selection panel
		add(BorderLayout.NORTH, this.selectionPanel);
		this.selectionPanel.setup();
		JComboBox<String> selectedMethod = this.selectionPanel.getSelectedMethod();
		selectedMethod.addActionListener(e -> {
			Object selected = selectedMethod.getSelectedItem();
			if (selected != null)
				this.resultPanel.setMethod(Methods.getFromName(selected.toString()));
		});

		// Set up the results panel
		add(BorderLayout.CENTER, resultPanel);
		this.resultPanel.setActiveSkills(defaultSkill);

		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent componentEvent) {
				pack();
			}
		});
	}

	public void addSkill(Skill skill) throws IOException {
		Skills key = skill.getKey();
		SkillPanel panel = new SkillPanel(skill);
		this.resultPanel.add(key.toString(), panel);

		JButton button = new JButton(new ImageIcon(ImageIO
				.read(getClass().getResource("/SkillIcons/" + key.toString().toLowerCase() + ".png"))
				.getScaledInstance(OSRSCalculator.SKILL_ICON_LENGTH, OSRSCalculator.SKILL_ICON_LENGTH, Image.SCALE_DEFAULT)));
		button.setToolTipText(key.toString());
		button.addActionListener(e -> {
			System.out.println("Selected calculator panel for " + key.toString());
			this.resultPanel.setActiveSkills(key);
			this.selectionPanel.setMethods(Arrays.stream(Methods.values()).filter(m -> m.getSkill().equals(key)).collect(Collectors.toList()));
			setSize(getPreferredSize().width,getMinimumSize().height + resultPanel.getPreferredSize().height);
		});
		this.selectionPanel.addButton(button);
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
