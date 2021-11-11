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

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Map;

public class RecipePanel extends JPanel {
	private final Recipe recipe;
	private final Methods method;
	private final OutcomePanel outcome;
	private final ProcessPanel process;
	private final CostPanel cost;

	// TODO: make this look decent
	public RecipePanel(Recipe recipe, Methods method) {
		super();
		setLayout(new BorderLayout(0, 0));
		Border border = BorderFactory.createLineBorder(Color.black);
		this.recipe = recipe;
		this.method = method;

		this.outcome = new OutcomePanel(recipe);
		this.outcome.setBorder(border);
		add(BorderLayout.WEST, outcome);

		this.process = new ProcessPanel(recipe);
		this.process.setBorder(border);
		add(BorderLayout.CENTER, process);

		this.cost = new CostPanel(recipe);
		this.cost.setBorder(border);
		add(BorderLayout.EAST, cost);
	}

	public void setCosts(Map<Integer, Float> out, Map<Integer, Float> in) {
		double costOut = out.values().stream().mapToDouble(v -> v).sum();
		double costIn = in.values().stream().mapToDouble(v -> v).sum();

		this.process.setCosts(costOut, costIn);
		this.cost.setProfit(costOut - costIn);
		repaint();
	}

	public Recipe getRecipe() {
		return this.recipe;
	}

	public Methods getMethod() {
		return method;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(outcome.getPreferredSize().width + process.getPreferredSize().width + cost.getPreferredSize().width, OSRSCalculator.RECIPEPANEL_HEIGHT);
	}
}
