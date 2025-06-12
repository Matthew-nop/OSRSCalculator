package nop.matthew.osrscalculator.ui;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Recipe;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;
import nop.matthew.osrscalculator.data.SortCriteria;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class SkillPanel extends JPanel {
	private final Skill skill;
	private final ArrayList<RecipePanel> recipePanels;
	private List<RecipePanel> shownPanels;
	private int count;

	public SkillPanel(Skill skill) {
		super(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		this.skill = skill;
		this.recipePanels = new ArrayList<>();
		this.count = 0;
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridwidth = 1;
		constraints.weighty = 0;
		for (Map.Entry<Methods, Recipe[]> entry : skill.getMethodRecipes().entrySet()) {
			Methods method = entry.getKey();
			Recipe[] recipes = entry.getValue();
			for (int i = 0; i < recipes.length; i++, this.count++) {
				RecipePanel recipePanel = new RecipePanel(recipes[i], method, skill);
				this.recipePanels.add(recipePanel);

				constraints.gridx = 0;
				constraints.gridy = this.count;
				add(recipePanel, constraints);
			}
		}
		constraints.weighty = 1;
		add(new JPanel(), constraints);

		this.recipePanels.trimToSize();
		this.shownPanels = new ArrayList<>(this.recipePanels);
		validate();
	}

	private void setShownPanels(List<RecipePanel> panels) {
		removeAll();
		GridBagConstraints constraints = new GridBagConstraints();

		this.count = 0;
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridwidth = 1;
		constraints.weighty = 0;

		int size = panels.size();
		for (; this.count < size; this.count++) {
			constraints.gridx = 0;
			constraints.gridy = this.count;
			add(panels.get(this.count), constraints);
		}
		constraints.weighty = 1;
		add(new JPanel(), constraints);

		validate();
		repaint();
		this.shownPanels = panels;
	}

	/**
	 * Update recipe panel cost information
	 */
	public void updateCosts() {
		this.recipePanels.forEach(RecipePanel::updateResults);
	}

	/**
	 * Update recipe panel action count information
	 *
	 * @param start the starting value
	 * @param end   the target value
	 * @param level true if the values represent levels,
	 *              false if they are xp values
	 */
	public void updateActions(int start, int end, boolean level) {
		if (level) {
			this.recipePanels.forEach(rp -> rp.updateActionLevel(start, end));
		}
		else {
			this.recipePanels.forEach(rp -> rp.updateActionXp(start, end));
		}
	}

	/**
	 * Set the method by which this skill's recipes will be filtered
	 *
	 * @param method the method to filter by
	 */
	public void setMethod(Methods method) {
		removeAll();
		ArrayList<RecipePanel> panels = new ArrayList<>(recipePanels);
		if (method != null) {
			panels.removeIf(p -> !p.getMethod().equals(method));
		}

		setShownPanels(panels);
	}

	/**
	 * Set the sorting criteria for the list of shown recipes
	 *
	 * @param sortCriteria the sorting criteria
	 */
	public void sortBy(SortCriteria sortCriteria) {
		if (sortCriteria == null) {
			return;
		}

		Comparator<RecipePanel> comparator = SortCriteria.getComparator(sortCriteria);
		if (comparator == null) {
			return;
		}

		this.shownPanels.sort(comparator);
		setShownPanels(this.shownPanels);
	}

	/**
	 * Set the given flag for this panel's skill
	 *
	 * @param flag the given flag
	 */
	public void setFlag(Flags flag) {
		this.skill.setFlag(flag);
	}

	/**
	 * Unset the given flag for this panel's skill
	 *
	 * @param flag the given flag
	 */
	public void unsetFlag(Flags flag) {
		this.skill.unsetFlag(flag);
	}

	/**
	 * Check if the given flag is set
	 *
	 * @param flag the given flag
	 * @return true if the flag is set, false if not
	 */
	public boolean checkFlag(Flags flag) {
		return this.skill.checkFlag(flag);
	}

	public Skills getSkills() {
		return skill.getSkills();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Calculator.getInstance().getWidth() - OSRSCalculator.VERTICAL_SCROLLBAR_WIDTH, OSRSCalculator.RECIPEPANEL_HEIGHT * this.count);
	}
}
