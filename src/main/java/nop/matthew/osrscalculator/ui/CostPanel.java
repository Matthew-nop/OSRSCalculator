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
	private JLabel profitLabel;
	private JLabel normalisedProfitLabel;

	public CostPanel(Recipe recipe) {
		super(new BorderLayout(0, 0));
		this.profitLabel = new JLabel();
		this.normalisedProfitLabel = new JLabel();

		this.profitLabel = new JLabel("0");
		add(BorderLayout.NORTH, this.profitLabel);
		this.normalisedProfitLabel = new JLabel("0");
		add(BorderLayout.SOUTH, this.normalisedProfitLabel);
	}

	/** Update the panel's information
	 *
	 * @param normalisedProfit the normalised profit to display
	 */
	public void setProfit(double profit, double normalisedProfit) {
		DecimalFormat df = new DecimalFormat("#.#");
		this.profitLabel.setText("Profit: " + df.format(profit));
		this.normalisedProfitLabel.setText("GP/XP: " + df.format(normalisedProfit));
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(OSRSCalculator.COST_WIDTH, OSRSCalculator.RECIPEPANEL_HEIGHT);
	}
}
