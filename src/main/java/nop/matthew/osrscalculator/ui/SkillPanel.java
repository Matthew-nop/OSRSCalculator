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

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Recipe;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;
import nop.matthew.osrscalculator.data.SortCriteria;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class SkillPanel extends JPanel {
	private final Skill skill;
	private final ArrayList<RecipePanel> recipePanels;
	private List<RecipePanel> shownPanels;
	private int count;

	public SkillPanel(Skill skill) {
		super(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		this.skill = skill;
		this.recipePanels = new ArrayList<>();
		this.count = 0;
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridwidth = 1;
		constraints.weighty = 0;
		for (Map.Entry<Methods, Recipe[]> entry : skill.getMethodRecipes().entrySet()) {
			Methods method = entry.getKey();
			Recipe[] recipes = entry.getValue();
			for (int i = 0; i < recipes.length; i++, this.count++) {
				RecipePanel recipePanel = new RecipePanel(recipes[i], method);
				this.recipePanels.add(recipePanel);

				constraints.gridx = 0;
				constraints.gridy = this.count;
				add(recipePanel, constraints);
			}
		}
		constraints.weighty = 1;
		add(new JPanel(), constraints);

		this.recipePanels.trimToSize();
		this.shownPanels = new ArrayList<>(this.recipePanels);
		validate();
	}

	private void setShownPanels(List<RecipePanel> panels) {
		removeAll();
		GridBagConstraints constraints = new GridBagConstraints();

		this.count = 0;
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridwidth = 1;
		constraints.weighty = 0;

		int size = panels.size();
		for (; this.count < size; this.count++) {
			constraints.gridx = 0;
			constraints.gridy = this.count;
			add(panels.get(this.count), constraints);
		}
		constraints.weighty = 1;
		add(new JPanel(), constraints);

		validate();
		repaint();
		this.shownPanels = panels;
	}

	/**
	 * Update recipe panel information
	 */
	public void update() {
		for (RecipePanel panel : this.recipePanels) {
			Recipe r = panel.getRecipe();
			panel.setCosts(this.skill.getRecipeOutCosts(r), this.skill.getRecipeInCosts(r));
		}
	}

	/**
	 * Set the method by which this skill's recipes will be filtered
	 *
	 * @param method the method to filter by
	 */
	public void setMethod(Methods method) {
		removeAll();
		ArrayList<RecipePanel> panels = new ArrayList<>(recipePanels);
		if (method != null)
			panels.removeIf(p -> !p.getMethod().equals(method));

		setShownPanels(panels);
	}

	/**
	 * Set the sorting criteria for the list of shown recipes
	 *
	 * @param sortCriteria the sorting criteria
	 */
	public void sortBy(SortCriteria sortCriteria) {
		if (sortCriteria == null)
			return;

		Comparator<RecipePanel> comparator = SortCriteria.getComparator(sortCriteria);
		if (comparator == null)
			return;

		this.shownPanels.sort(comparator);
		setShownPanels(this.shownPanels);
	}

	/**
	 * Set the given flag for this panel's skill
	 *
	 * @param flag the given flag
	 */
	public void setFlag(Flags flag) {
		this.skill.setFlag(flag);
	}

	/** Unset the given flag for this panel's skill
	 *
	 * @param flag the given flag
	 */
	public void unsetFlag(Flags flag) {
		this.skill.unsetFlag(flag);
	}

	public Skills getSkills() {
		return skill.getSkills();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(OSRSCalculator.calculator.getWidth() - OSRSCalculator.VERTICAL_SCROLLBAR_WIDTH, OSRSCalculator.RECIPEPANEL_HEIGHT * this.count);
	}
}
