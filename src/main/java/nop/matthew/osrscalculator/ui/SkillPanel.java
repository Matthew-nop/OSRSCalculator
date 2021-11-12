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
import nop.matthew.osrscalculator.data.Recipe;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SkillPanel extends JPanel {
	private final Skill skill;
	private final ArrayList<RecipePanel> recipePanels;
	private final JScrollPane scrollPane;

	public SkillPanel(Skill skill) {
		super(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		this.skill = skill;
		this.recipePanels = new ArrayList<RecipePanel>();
		int count = 0;
		constraints.anchor = GridBagConstraints.NORTHEAST;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridwidth = 1;
		constraints.weighty = 0;
		for (Map.Entry<Methods, Recipe[]> entry : skill.getMethodRecipes().entrySet()) {
			Methods method = entry.getKey();
			Recipe[] recipes = entry.getValue();
			for (int i = 0; i < recipes.length; i++, count++) {
				RecipePanel recipePanel = new RecipePanel(recipes[i], method);
				this.recipePanels.add(recipePanel);

				constraints.gridx = 0;
				constraints.gridy = count;
				add(recipePanel, constraints);
			}
		}
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weighty = 1;
		add(new JPanel(), constraints);

		this.recipePanels.trimToSize();
		scrollPane = new JScrollPane(this, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER) {
			@Override
			public Dimension getPreferredSize() {
				return this.viewport.getPreferredSize();
			}
		};
	}

	/** Update recipe panel information
	 *
	 */
	public void update() {
		for (RecipePanel panel : recipePanels) {
			Recipe r = panel.getRecipe();
			panel.setCosts(this.skill.getRecipeOutCosts(r), this.skill.getRecipeInCosts(r));
		}
	}

	/** Set the method by which this skill's recipes will be filtered
	 *
	 * @param method the method to filter by
	 */
	public void setMethod(Methods method) {
		removeAll();
		GridBagConstraints constraints = new GridBagConstraints();

		int count = 0;
		constraints.anchor = GridBagConstraints.NORTHEAST;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridwidth = 1;
		constraints.weighty = 0;
		List<RecipePanel> panels = this.recipePanels;
		if (method != null)
			panels = panels.stream()
					.filter(r -> r.getMethod().equals(method))
					.collect(Collectors.toList());
		int size = panels.size();
		for (int i = 0; i < size; i++, count++) {
			RecipePanel recipePanel = panels.get(i);
			constraints.gridx = 0;
			constraints.gridy = count;
			add(recipePanel, constraints);
		}

		constraints.fill = GridBagConstraints.VERTICAL;
		constraints.weighty = 1;
		add(new JPanel(), constraints);

		repaint();
		revalidate();
	}

	public Skills getSkills() {
		return skill.getSkills();
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(OSRSCalculator.calculator.getWidth() - OSRSCalculator.VERTICAL_SCROLLBAR_WIDTH, OSRSCalculator.RECIPEPANEL_HEIGHT*this.recipePanels.size());
	}
}
