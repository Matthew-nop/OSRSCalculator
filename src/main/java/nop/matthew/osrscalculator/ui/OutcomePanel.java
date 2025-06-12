package nop.matthew.osrscalculator.ui;

import nop.matthew.osrscalculator.data.Recipe;
import nop.matthew.osrscalculator.data.Skill;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;

public class OutcomePanel extends JPanel {
	private final JLabel xpLabel;

	public OutcomePanel(Recipe recipe, Skill skill) {
		super(new BorderLayout(0, 0));

		this.xpLabel = new JLabel();
		DecimalFormat df = new DecimalFormat(OSRSCalculator.DECIMAL_FORMAT_STRING);
		setXp(df.format(skill.getXp(recipe)));

		JLabel imageLabel = new JLabel();
		int level = recipe.getLevel();
		imageLabel.setToolTipText(recipe.getName());
		imageLabel.setLayout(new BorderLayout(0, 0));
		JLabel levelLabel = new JLabel("Lvl " + recipe.getLevel());
		Font defaultFont = imageLabel.getFont();
		levelLabel.setFont(new Font(defaultFont.getFontName(), Font.BOLD, 16));
		imageLabel.add(BorderLayout.NORTH, levelLabel);

		add(BorderLayout.CENTER, imageLabel); // TODO: place an image
		add(BorderLayout.SOUTH, this.xpLabel);
	}

	public void setXp(String xp) {
		this.xpLabel.setText(xp  + "xp");
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(OSRSCalculator.OUTCOME_WIDTH, OSRSCalculator.RECIPEPANEL_HEIGHT);
	}
}
