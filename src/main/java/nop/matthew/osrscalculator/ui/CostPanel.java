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
