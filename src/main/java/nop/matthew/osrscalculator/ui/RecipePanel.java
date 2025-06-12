package nop.matthew.osrscalculator.ui;

import nop.matthew.osrscalculator.data.Experience;
import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Recipe;
import nop.matthew.osrscalculator.data.Skill;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.DecimalFormat;

public class RecipePanel extends JPanel {
	private final Recipe recipe;
	private final Methods method;
	private final Skill skill;
	private final OutcomePanel outcome;
	private final IngredientsPanel ingredients;
	private final EfficiencyPanel efficiency;
	private double xp;
	private double profit;
	private double normalisedProfit;

	public RecipePanel(Recipe recipe, Methods method, Skill skill) {
		super(new FlowLayout(FlowLayout.LEFT, 0, 0));
		this.profit = 0;
		this.normalisedProfit = 0;
		this.xp = skill.getXp(recipe);
		Border border = BorderFactory.createLineBorder(Color.black);
		this.recipe = recipe;
		this.method = method;
		this.skill = skill;

		this.outcome = new OutcomePanel(recipe, skill);
		this.outcome.setBorder(border);
		add(BorderLayout.WEST, outcome);

		this.ingredients = new IngredientsPanel(recipe, skill);
		this.ingredients.setBorder(border);
		add(BorderLayout.CENTER, ingredients);

		this.efficiency = new EfficiencyPanel();
		this.efficiency.setBorder(border);
		add(BorderLayout.EAST, efficiency);

		validate();
	}

	/**
	 * Update this panel's information
	 */
	public void updateResults() {
		double costOut = this.skill.getRecipeOutCosts(this.recipe).values().stream().mapToDouble(v -> v).sum();
		double costIn = this.skill.getRecipeInCosts(this.recipe).values().stream().mapToDouble(v -> v).sum();
		this.profit = costOut - costIn;
		this.xp = this.skill.getXp(this.recipe);
		this.normalisedProfit = this.profit / xp;

		DecimalFormat df = new DecimalFormat(OSRSCalculator.DECIMAL_FORMAT_STRING);
		this.outcome.setXp(df.format(xp));
		this.ingredients.setCost(df.format(costIn));
		this.efficiency.setProfits(normalisedProfit, profit);
		repaint();
	}

	/**
	 * Update this panel's action count from the given xp values
	 *
	 * @param startXp the starting xp value
	 * @param endXp   the ending xp value
	 */
	public void updateActionsXp(int startXp, int endXp) {
		SelectionPanel selectionPanel = SelectionPanel.getInstance();
		if (startXp < 0) {
			startXp = 0;
		}
		else if (startXp > Experience.MAX_EXPERIENCE) {
			startXp = Experience.MAX_EXPERIENCE;
		}
		if (endXp < 0) {
			endXp = 0;
		}
		else if (endXp > Experience.MAX_EXPERIENCE) {
			endXp = Experience.MAX_EXPERIENCE;
		}

		selectionPanel.setStartBoxText(String.valueOf(startXp));
		selectionPanel.setEndBoxText(String.valueOf(endXp));
		updateActions(startXp, endXp);
	}

	/**
	 * Update this panel's action count from the given player level
	 *
	 * @param startLvl the starting level
	 * @param endLvl   the ending level
	 */
	public void updateActionsLevel(int startLvl, int endLvl) {
		SelectionPanel selectionPanel = SelectionPanel.getInstance();
		if (startLvl < 0) {
			startLvl = 0;
		}
		else if (startLvl > Experience.LEVEL_MAX_VIRT) {
			startLvl = Experience.LEVEL_MAX_VIRT;
		}
		if (endLvl < 0) {
			endLvl = 0;
		}
		else if (endLvl > Experience.LEVEL_MAX_VIRT) {
			endLvl = Experience.LEVEL_MAX_VIRT;
		}

		selectionPanel.setStartBoxText(String.valueOf(startLvl));
		selectionPanel.setEndBoxText(String.valueOf(endLvl));
		int startXp = Experience.getXpFromLevel(startLvl);
		int endXp = Experience.getXpFromLevel(endLvl);
		updateActions(startXp, endXp);
	}

	private void updateActions(int startXp, int endXp) {
		DecimalFormat df = new DecimalFormat(OSRSCalculator.DECIMAL_FORMAT_STRING);
		int count = (int) Math.ceil((endXp - startXp) / xp);
		this.efficiency.setActionCount(df.format(count));
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
		return new Dimension(outcome.getPreferredSize().width + ingredients.getPreferredSize().width + efficiency.getPreferredSize().width, OSRSCalculator.RECIPEPANEL_HEIGHT);
	}
}
