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

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DecimalFormat;

public class EfficiencyPanel extends JPanel {
	private final JLabel normalisedProfitLabel;
	private final JLabel profitLabel;
	private final JLabel actionCountLabel;

	public EfficiencyPanel() {
		super(new GridLayout(0, 1, 0, 0));

		this.normalisedProfitLabel = new JLabel();
		this.profitLabel = new JLabel();
		this.actionCountLabel = new JLabel();
		setProfits(0d, 0d);
		setActionCount("0");

		add(this.normalisedProfitLabel);
		add(this.profitLabel);
		add(this.actionCountLabel);
	}

	/**
	 * Update the panel's information
	 *
	 * @param normalisedProfit the normalised profit to display
	 */
	public void setProfits(double normalisedProfit, double profit) {
		DecimalFormat df = new DecimalFormat(OSRSCalculator.DECIMAL_FORMAT_STRING);
		String profitString = df.format(profit);
		String normalisedProfitString = df.format(normalisedProfit);
		this.profitLabel.setText(" Profit: " + profitString);
		this.profitLabel.setToolTipText(profitString);
		this.normalisedProfitLabel.setText(" GP/XP: " + normalisedProfitString);
		this.normalisedProfitLabel.setToolTipText(normalisedProfitString);
		if (profit >= 0) {
			this.profitLabel.setForeground(new Color(0x00AB66));
			this.normalisedProfitLabel.setForeground(new Color(0x00AB66));
		}
		else {
			this.profitLabel.setForeground(new Color(0xE30022));
			this.normalisedProfitLabel.setForeground(new Color(0xE30022));
		}
	}

	public void setActionCount(String actionCount) {
		this.actionCountLabel.setText(" Actions: " + actionCount);
		this.actionCountLabel.setToolTipText(actionCount);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(OSRSCalculator.EFFICIENCY_WIDTH, OSRSCalculator.RECIPEPANEL_HEIGHT);
	}
}
