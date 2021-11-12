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

public class ProcessPanel extends JPanel {
	JLabel outputs;
	JLabel inputs;

	public ProcessPanel(Recipe recipe) {
		super(new BorderLayout(0, 0));

		this.outputs = new JLabel("0");
		add(BorderLayout.NORTH, this.outputs);
		this.inputs = new JLabel("0");
		add(BorderLayout.SOUTH, this.inputs);
	}

	/** Update the panel's information
	 *
	 * @param costOut The sum of costs for outputs
	 * @param costIn The sum of costs for inputs
	 */
	public void setCosts(double costOut, double costIn) {
		DecimalFormat df = new DecimalFormat("#.#");
		this.outputs.setText("Output: " + df.format(costOut));
		this.inputs.setText("Input: " + df.format(costIn));
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(OSRSCalculator.calculator.getWidth() + OSRSCalculator.PROCESS_WIDTH_OFFSET, OSRSCalculator.RECIPEPANEL_HEIGHT);
	}
}
