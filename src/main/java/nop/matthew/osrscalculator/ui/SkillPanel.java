package nop.matthew.osrscalculator.ui;

import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Recipe;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SkillPanel extends JPanel {
	private final Skill skill;
	private final ArrayList<RecipePanel> recipePanels;
	private int count;

	public SkillPanel(Skill skill) {
		super(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		this.skill = skill;
		this.recipePanels = new ArrayList<RecipePanel>();
		this.count = 0;
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridwidth = 1;
		constraints.weighty = 0;
		for (Map.Entry<Methods, Recipe[]> entry : skill.getMethodRecipes().entrySet()) {
			Methods method = entry.getKey();
			Recipe[] recipes = entry.getValue();
			for (int i = 0; i < recipes.length; i++, this.count++) {
				RecipePanel recipePanel = new RecipePanel(recipes[i], method);
				this.recipePanels.add(recipePanel);

				constraints.gridx = 0;
				constraints.gridy = this.count;
				add(recipePanel, constraints);
			}
		}
		constraints.weighty = 1;
		add(new JPanel(), constraints);

		this.recipePanels.trimToSize();
		validate();
	}

	/** Update recipe panel information
	 *
	 */
	public void update() {
		for (RecipePanel panel : recipePanels) {
			Recipe r = panel.getRecipe();
			panel.setCosts(this.skill.getRecipeOutCosts(r), this.skill.getRecipeInCosts(r));
		}
	}

	/** Set the method by which this skill's recipes will be filtered
	 *
	 * @param method the method to filter by
	 */
	public void setMethod(Methods method) {
		removeAll();
		GridBagConstraints constraints = new GridBagConstraints();

		this.count = 0;
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridwidth = 1;
		constraints.weighty = 0;
		List<RecipePanel> panels = this.recipePanels;
		if (method != null)
			panels = panels.stream()
					.filter(r -> r.getMethod().equals(method))
					.collect(Collectors.toList());
		int size = panels.size();
		for (; this.count < size; this.count++) {
			RecipePanel recipePanel = panels.get(this.count);
			constraints.gridx = 0;
			constraints.gridy = this.count;
			add(recipePanel, constraints);
		}
		constraints.weighty = 1;
		add(new JPanel(), constraints);

		repaint();
		revalidate();
	}

	public Skills getSkills() {
		return skill.getSkills();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(OSRSCalculator.calculator.getWidth() - OSRSCalculator.VERTICAL_SCROLLBAR_WIDTH, OSRSCalculator.RECIPEPANEL_HEIGHT*this.count);
	}
}
