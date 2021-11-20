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

import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class IngredientsPanel extends JPanel {
	private final JLabel costSum;

	public IngredientsPanel(Recipe recipe) {
		super(new BorderLayout(0, 0));

		this.costSum = new JLabel();
		this.costSum.setBackground(Color.LIGHT_GRAY);
		this.costSum.setOpaque(true);
		JPanel ingredients = new JPanel(new GridLayout(0, 1, 0, 0));
		for (ItemQuantity itemQuantity : recipe.getIngredients()) {
			ingredients.add(new JLabel(((int) itemQuantity.getQuantity()) + "x " + itemQuantity.getName()));
		}
		setCosts("0");

		add(BorderLayout.SOUTH, this.costSum);
		add(BorderLayout.NORTH, ingredients);
	}

	/**
	 * Update the panel's information
	 *
	 * @param costSum The sum of costs for inputs
	 */
	public void setCosts(String costSum) {
		this.costSum.setText("Input: " + costSum);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(OSRSCalculator.calculator.getWidth() + OSRSCalculator.PROCESS_WIDTH_OFFSET, OSRSCalculator.RECIPEPANEL_HEIGHT);
	}
}
