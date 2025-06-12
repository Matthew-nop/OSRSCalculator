package nop.matthew.osrscalculator.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;

public class EfficiencyPanel extends JPanel {
	private final JLabel normalisedProfitLabel;
	private final JLabel profitLabel;
	private final JLabel actionCountLabel;

	public EfficiencyPanel() {
		super(new GridLayout(0, 1, 0, 0));
		this.normalisedProfitLabel = new JLabel();
		this.profitLabel = new JLabel();
		this.actionCountLabel = new JLabel();

		setEfficiency("0", "0", "0");
		add(this.normalisedProfitLabel);
		add(this.profitLabel);
		add(this.actionCountLabel);
	}

	/**
	 * Update the panel's information
	 *
	 * @param normalisedProfit the normalised profit to display
	 */
	public void setEfficiency(String normalisedProfit, String profit, String actionCount) {
		this.profitLabel.setText("Profit: " + profit);
		this.normalisedProfitLabel.setText("GP/XP: " + normalisedProfit);
		this.actionCountLabel.setText("Actions: " + actionCount);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(OSRSCalculator.COST_WIDTH, OSRSCalculator.RECIPEPANEL_HEIGHT);
	}
}
