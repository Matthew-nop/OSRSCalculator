package ui;

import data.Recipe;
import data.Skill;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import java.util.ArrayList;

public class SkillPanel extends JPanel {
	private final Skill skill;
	private final ArrayList<RecipePanel> recipePanels;
	private final JScrollPane scrollPane;

	public SkillPanel(Skill skill) {
		super(new GridLayout(0, 1));
		this.skill = skill;
		recipePanels = new ArrayList<RecipePanel>();
		for (Recipe[] recipes : skill.getMethodRecipes().values()) {
			for (Recipe recipe : recipes) {
				RecipePanel recipePanel = new RecipePanel(recipe);
				recipePanels.add(recipePanel);
				add(recipePanel);
			}
		}

		scrollPane = new JScrollPane(this, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}

	public void update() {
		for (RecipePanel panel : recipePanels) {
			Recipe r = panel.getRecipe();
			panel.setCosts(this.skill.getRecipeOutCosts(r), this.skill.getRecipeInCosts(r));
		}
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}
}
