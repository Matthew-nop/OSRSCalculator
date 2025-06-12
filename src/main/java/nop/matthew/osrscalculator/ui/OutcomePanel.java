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
		DecimalFormat df = new DecimalFormat(OSRSCalculator.DECIMAL_FORMAT_STRING);
		setXp(df.format(skill.getXp(recipe)));

		add(BorderLayout.CENTER, new JLabel(recipe.getName())); // TODO: place an image
		add(BorderLayout.SOUTH, this.levelLabel);
	}

	public void setXp(String xp) {
		this.levelLabel.setText("Lvl " + this.level + " - " + xp  + "xp");
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(OSRSCalculator.OUTCOME_WIDTH, OSRSCalculator.RECIPEPANEL_HEIGHT);
	}
}
