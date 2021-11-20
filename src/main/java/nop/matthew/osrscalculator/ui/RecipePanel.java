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

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.DecimalFormat;

public class RecipePanel extends JPanel {
	private final Recipe recipe;
	private final Methods method;
	private final Skill skill;
	private final OutcomePanel outcome;
	private final IngredientsPanel ingredients;
	private final EfficiencyPanel efficiency;
	private double xp;
	private double profit;
	private double normalisedProfit;

	// TODO: make this look decent
	public RecipePanel(Recipe recipe, Methods method, Skill skill) {
		super(new FlowLayout(FlowLayout.LEFT, 0, 0));
		this.profit = 0;
		this.normalisedProfit = 0;
		this.xp = skill.getXp(recipe);
		Border border = BorderFactory.createLineBorder(Color.black);
		this.recipe = recipe;
		this.method = method;
		this.skill = skill;

		this.outcome = new OutcomePanel(recipe, skill);
		this.outcome.setBorder(border);
		add(BorderLayout.WEST, outcome);

		this.ingredients = new IngredientsPanel(recipe);
		this.ingredients.setBorder(border);
		add(BorderLayout.CENTER, ingredients);

		this.efficiency = new EfficiencyPanel();
		this.efficiency.setBorder(border);
		add(BorderLayout.EAST, efficiency);

		validate();
	}

	/**
	 * Update this panel's information
	 */
	public void updateResults() {
		double costOut = this.skill.getRecipeOutCosts(this.recipe).values().stream().mapToDouble(v -> v).sum();
		double costIn = this.skill.getRecipeInCosts(this.recipe).values().stream().mapToDouble(v -> v).sum();
		this.profit = costOut - costIn;
		this.xp = this.skill.getXp(this.recipe);
		this.normalisedProfit = this.profit / xp;

		DecimalFormat df = new DecimalFormat(OSRSCalculator.DECIMAL_FORMAT_STRING);
		this.outcome.setXp(df.format(xp));
		this.ingredients.setCost(df.format(costIn));
		this.efficiency.setProfits(normalisedProfit, profit);
		repaint();
	}

	public void updateActionXp(int start, int end) {
		DecimalFormat df = new DecimalFormat(OSRSCalculator.DECIMAL_FORMAT_STRING);
		int count = (int) Math.ceil((end - start)/xp);
		this.efficiency.setActionCount(df.format(count));
	}

	public void updateActionLevel(int start, int end) {
		// stub
	}

	public Recipe getRecipe() {
		return this.recipe;
	}

	public Methods getMethod() {
		return this.method;
	}

	public double getProfit() {
		return this.profit;
	}

	public double getNormalisedProfit() {
		return this.normalisedProfit;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(outcome.getPreferredSize().width + ingredients.getPreferredSize().width + efficiency.getPreferredSize().width, OSRSCalculator.RECIPEPANEL_HEIGHT);
	}
}
