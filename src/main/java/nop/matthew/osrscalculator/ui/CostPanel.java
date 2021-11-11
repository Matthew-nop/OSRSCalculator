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

import nop.matthew.osrscalculator.data.Recipe;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.DecimalFormat;

public class CostPanel extends JPanel {
	private JLabel profit;
	private JLabel profitNormalised;
	private final float xp;

	public CostPanel(Recipe recipe) {
		super();
		this.profit = new JLabel();
		this.profitNormalised = new JLabel();
		this.xp = recipe.getXp();

		this.profit = new JLabel("0");
		add(BorderLayout.NORTH, this.profit);
		this.profitNormalised = new JLabel("0");
		add(BorderLayout.SOUTH, this.profitNormalised);
	}

	public void setProfit(double profit) {
		DecimalFormat df = new DecimalFormat("#.#");
		this.profit.setText("Profit: " + df.format(profit));
		this.profitNormalised.setText("GP/XP: " + df.format(profit / this.xp));
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(OSRSCalculator.COST_WIDTH, OSRSCalculator.RECIPEPANEL_HEIGHT);
	}
}
