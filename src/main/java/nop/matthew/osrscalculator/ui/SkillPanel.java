package nop.matthew.osrscalculator.ui;

import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Recipe;
import nop.matthew.osrscalculator.data.Skill;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Map;

public class SkillPanel extends JPanel {
	private final Skill skill;
	private final ArrayList<RecipePanel> recipePanels;
	private final JScrollPane scrollPane;

	public SkillPanel(Skill skill) {
		super(new GridLayout(0, 1));
		this.skill = skill;
		recipePanels = new ArrayList<RecipePanel>();
		for (Map.Entry<Methods, Recipe[]> entry : skill.getMethodRecipes().entrySet()) {
			for (Recipe recipe : entry.getValue()) {
				RecipePanel recipePanel = new RecipePanel(recipe, entry.getKey());
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
