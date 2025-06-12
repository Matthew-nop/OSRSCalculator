package nop.matthew.osrscalculator.ui;

import nop.matthew.osrscalculator.data.Recipe;
import nop.matthew.osrscalculator.data.Skill;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.DecimalFormat;

public class OutcomePanel extends JPanel {
	private final JLabel levelLabel;
	private final int level;

	public OutcomePanel(Recipe recipe, Skill skill) {
		super(new BorderLayout(0, 0));
		this.level = recipe.getLevel();
		this.levelLabel = new JLabel();
		setXp(skill.getXp(recipe));

		add(BorderLayout.CENTER, new JLabel(recipe.getName())); // TODO: place an image
		add(BorderLayout.SOUTH, this.levelLabel);
	}

	public void setXp(double xp) {
		DecimalFormat df = new DecimalFormat("#.#");
		this.levelLabel.setText("Lvl " + this.level + " - " + df.format(xp) + "xp");
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(OSRSCalculator.OUTCOME_WIDTH, OSRSCalculator.RECIPEPANEL_HEIGHT);
	}
}
