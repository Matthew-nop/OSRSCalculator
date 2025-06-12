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
