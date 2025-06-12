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
		this.profitLabel.setText(" Profit: " + df.format(profit));
		this.normalisedProfitLabel.setText(" GP/XP: " + df.format(normalisedProfit));
		if (profit >= 0) {
			this.profitLabel.setForeground(Color.GREEN);
			this.normalisedProfitLabel.setForeground(Color.GREEN);
		}
		else {
			this.profitLabel.setForeground(Color.RED);
			this.normalisedProfitLabel.setForeground(Color.RED);
		}
	}

	public void setActionCount(String actionCount) {
		this.actionCountLabel.setText(" Actions: " + actionCount);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(OSRSCalculator.EFFICIENCY_WIDTH, OSRSCalculator.RECIPEPANEL_HEIGHT);
	}
}
