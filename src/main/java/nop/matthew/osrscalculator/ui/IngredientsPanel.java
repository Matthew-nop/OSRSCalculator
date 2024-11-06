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
import nop.matthew.osrscalculator.data.Skill;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DecimalFormat;

public class IngredientsPanel extends JPanel {
	private final JLabel costSum;

	public IngredientsPanel(Recipe recipe, Skill skill) {
		super(new BorderLayout(0, 0));

		this.costSum = new JLabel();
		this.costSum.setBackground(Color.LIGHT_GRAY);
		this.costSum.setOpaque(true);
		this.costSum.setBorder(new EmptyBorder(0, OSRSCalculator.TEXT_BORDER_SIZE, 0, OSRSCalculator.TEXT_BORDER_SIZE));
		JPanel ingredients = new JPanel(new GridLayout(0, 1, 0, 0));
		ingredients.setBorder(new EmptyBorder(OSRSCalculator.TEXT_BORDER_SIZE, OSRSCalculator.TEXT_BORDER_SIZE, OSRSCalculator.TEXT_BORDER_SIZE, OSRSCalculator.TEXT_BORDER_SIZE));
		DecimalFormat df = new DecimalFormat(OSRSCalculator.DECIMAL_FORMAT_STRING);
		for (ItemQuantity itemQuantity : recipe.getIngredients(skill.getFlags())) {
			String normalisedQuantityString = df.format(itemQuantity.getQuantity());
			ingredients.add(new JLabel(normalisedQuantityString + "x " + itemQuantity.getName()));
		}
		setCost("0");

		add(BorderLayout.SOUTH, this.costSum);
		add(BorderLayout.NORTH, ingredients);
	}

	/**
	 * Update the panel's information
	 *
	 * @param costSum The sum of costs for inputs
	 */
	public void setCost(String costSum) {
		this.costSum.setText("Input: " + costSum);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Calculator.getInstance().getWidth() + OSRSCalculator.PROCESS_WIDTH_OFFSET, OSRSCalculator.RECIPEPANEL_HEIGHT);
	}
}
