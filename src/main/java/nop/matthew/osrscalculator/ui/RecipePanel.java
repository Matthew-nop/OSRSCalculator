package nop.matthew.osrscalculator.ui;

import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Recipe;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.Map;

public class RecipePanel extends JPanel {
	public final static int RECIPEPANEL_HEIGHT = 50;
	public final static int OUTCOME_WIDTH = 100;
	public final static int COST_WIDTH = 100;

	private Recipe recipe;
	private Methods method;
	private JPanel outcome;
	private JPanel process;
	private JPanel cost;
	private JLabel profit;
	private JLabel profitNormalised;
	private JLabel outputs;
	private JLabel inputs;

	// TODO: make this look decent
	public RecipePanel(Recipe recipe, Methods method) {
		super();
		setLayout(new BorderLayout(0, 0));
		Border border = BorderFactory.createLineBorder(Color.black);
		this.recipe = recipe;
		this.method = method;

		this.outcome = new JPanel(new BorderLayout(0, 0));
		ItemQuantity[] output = recipe.getOutput();
		this.outcome.add(BorderLayout.CENTER, new JLabel(recipe.getName())); // TODO: place an image
		this.outcome.add(BorderLayout.SOUTH, new JLabel(recipe.getLevel() + " - " + recipe.getXp()));
		this.outcome.setPreferredSize(new Dimension(OUTCOME_WIDTH, RECIPEPANEL_HEIGHT));
		this.outcome.setBorder(border);
		add(BorderLayout.WEST, outcome);

		this.process = new JPanel(new BorderLayout(0, 0));
		this.outputs = new JLabel("0");
		this.process.add(BorderLayout.NORTH, this.outputs);
		this.inputs = new JLabel("0");
		this.process.add(BorderLayout.SOUTH, this.inputs);
		this.process.setPreferredSize(new Dimension(OSRSCalculator.calculator.getWidth() - OUTCOME_WIDTH - COST_WIDTH, RECIPEPANEL_HEIGHT));
		this.process.setBorder(border);
		add(BorderLayout.CENTER, process);

		this.cost = new JPanel(new BorderLayout(0, 0));
		this.profit = new JLabel("0");
		this.cost.add(BorderLayout.NORTH, this.profit);
		this.profitNormalised = new JLabel("0");
		this.cost.add(BorderLayout.SOUTH, this.profitNormalised);
		this.cost.setPreferredSize(new Dimension(COST_WIDTH, RECIPEPANEL_HEIGHT));
		this.cost.setBorder(border);
		add(BorderLayout.EAST, cost);
	}

	public void setCosts(Map<Integer, Float> out, Map<Integer, Float> in) {
		float sumOut = 0;
		float sumIn = 0;
		for (float cost : out.values()) {
			sumOut += cost;
		}
		for (float cost : in.values()) {
			sumIn += cost;
		}

		DecimalFormat df = new DecimalFormat("#.#");
		this.outputs.setText("Output: " + df.format(sumOut));
		this.inputs.setText("Input: " + df.format(sumIn));
		this.profit.setText("Profit: " + df.format(sumOut - sumIn));
		this.profitNormalised.setText("GP/XP: " + df.format((sumOut - sumIn) / this.recipe.getXp()));
		repaint();
	}

	public Recipe getRecipe() {
		return this.recipe;
	}

	public Methods getMethod() {
		return method;
	}

	@Override
	public Dimension getMinimumSize() {
		return new Dimension(OSRSCalculator.calculator.getWidth(), RECIPEPANEL_HEIGHT);
	}
}
