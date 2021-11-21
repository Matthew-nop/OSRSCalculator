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
import nop.matthew.osrscalculator.data.Skills;
import nop.matthew.osrscalculator.data.SortCriteria;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.HashMap;

class ResultPanel extends JPanel {
	private SkillPanel currentPanel;
	private final CardLayout cardLayout;
	private final HashMap<Skills, SkillPanel> skillPanels;
	private static ResultPanel resultPanel = null;

	private ResultPanel() {
		super(new CardLayout(0, 0));
		this.cardLayout = (CardLayout) getLayout();
		this.skillPanels = new HashMap<>(OSRSCalculator.SKILL_COUNT);
	}

	synchronized public static ResultPanel getInstance() {
		if (resultPanel == null) {
			resultPanel = new ResultPanel();
		}
		return resultPanel;
	}

	/**
	 * Add the given SkillPanel to the panel
	 *
	 * @param skillPanel the SkillPanel to add
	 * @return the added SkillPanel
	 */
	public Component add(SkillPanel skillPanel) {
		super.add(skillPanel.getSkills().toString(), new JScrollPane(new ScrollSkillPanel(skillPanel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		this.skillPanels.put(skillPanel.getSkills(), skillPanel);
		return skillPanel;
	}

	/**
	 * Set the active skill which is displayed
	 *
	 * @param skills the skill to change to.
	 */
	public void setActiveSkills(Skills skills) {
		this.cardLayout.show(this, skills.toString());
		this.currentPanel = this.skillPanels.get(skills);
		this.currentPanel.updateCosts();
	}

	/**
	 * Update the costs of the current displayed panel
	 */
	public void updateCosts() {
		if (this.currentPanel != null) {
			this.currentPanel.updateCosts();
		}
	}

	/**
	 * Set the method by which the active skill's recipes will be filtered
	 *
	 * @param method the method to filter by
	 */
	public void setMethod(Methods method) {
		if (this.currentPanel != null) {
			this.currentPanel.setMethod(method);
		}
	}

	/**
	 * Sort the active skill's list of RecipePanels
	 *
	 * @param sortCriteria the SortCriteria to sort by
	 */
	public void sortBy(SortCriteria sortCriteria) {
		if (this.currentPanel != null) {
			this.currentPanel.sortBy(sortCriteria);
		}
		repaint();
	}

	public SkillPanel getCurrentPanel() {
		return this.currentPanel;
	}

	public Skills getActiveSkills() {
		return this.currentPanel.getSkills();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(getWidth(), getHeight());
	}

	@Override
	public Dimension getMinimumSize() {
		return new Dimension(0, 0);
	}
}
