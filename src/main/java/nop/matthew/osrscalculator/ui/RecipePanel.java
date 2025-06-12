package nop.matthew.osrscalculator.ui;

import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Recipe;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Map;

public class RecipePanel extends JPanel {
	private final Recipe recipe;
	private final Methods method;
	private final OutcomePanel outcome;
	private final ProcessPanel process;
	private final CostPanel cost;
	private double profit;
	private double normalisedProfit;

	// TODO: make this look decent
	public RecipePanel(Recipe recipe, Methods method) {
		super(new FlowLayout(FlowLayout.LEFT, 0, 0));
		this.profit = 0;
		this.normalisedProfit = 0;
		Border border = BorderFactory.createLineBorder(Color.black);
		this.recipe = recipe;
		this.method = method;

		this.outcome = new OutcomePanel(recipe);
		this.outcome.setBorder(border);
		add(BorderLayout.WEST, outcome);

		this.process = new ProcessPanel(recipe);
		this.process.setBorder(border);
		add(BorderLayout.CENTER, process);

		this.cost = new CostPanel(recipe);
		this.cost.setBorder(border);
		add(BorderLayout.EAST, cost);

		validate();
	}

	/**
	 * Set the costs for this panel
	 *
	 * @param out the output cost map
	 * @param in  the input cost map
	 */
	public void setCosts(Map<Integer, Float> out, Map<Integer, Float> in) {
		double costOut = out.values().stream().mapToDouble(v -> v).sum();
		double costIn = in.values().stream().mapToDouble(v -> v).sum();
		this.profit = costOut - costIn;
		this.normalisedProfit = this.profit / (double) this.recipe.getXp();

		this.process.setCosts(costOut, costIn);
		this.cost.setProfit(profit, normalisedProfit);
		repaint();
	}

	public Recipe getRecipe() {
		return this.recipe;
	}

	public Methods getMethod() {
		return this.method;
	}

	public double getProfit() {
		return this.profit;
	}

	public double getNormalisedProfit() {
		return this.normalisedProfit;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(outcome.getPreferredSize().width + process.getPreferredSize().width + cost.getPreferredSize().width, OSRSCalculator.RECIPEPANEL_HEIGHT);
	}
}
