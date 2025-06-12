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

	/**
	 * Update the panel's information
	 *
	 * @param costOut The sum of costs for outputs
	 * @param costIn  The sum of costs for inputs
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
