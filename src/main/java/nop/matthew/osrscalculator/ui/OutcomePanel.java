package nop.matthew.osrscalculator.ui;

import nop.matthew.osrscalculator.data.Recipe;
import nop.matthew.osrscalculator.data.Skill;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;

public class OutcomePanel extends JPanel {
	private final JLabel xpLabel;

	public OutcomePanel(Recipe recipe, Skill skill) {
		super(new BorderLayout(0, 0));

		// Set up the XP label
		this.xpLabel = new JLabel();
		this.xpLabel.setBackground(Color.LIGHT_GRAY);
		this.xpLabel.setOpaque(true);
		this.xpLabel.setBorder(new EmptyBorder(0, OSRSCalculator.TEXT_BORDER_SIZE, 0, OSRSCalculator.TEXT_BORDER_SIZE));
		DecimalFormat df = new DecimalFormat(OSRSCalculator.DECIMAL_FORMAT_STRING);
		setXp(df.format(skill.getXp(recipe)));

		// Set up the image label
		JLabel imageLabel = new JLabel();
		try {
			URL imagePath = recipe.getIconPath();
			if(imagePath != null) {
				ImageIcon image = new ImageIcon(ImageIO.read(imagePath));
				imageLabel = new JLabel(image);
			}
		} catch (IOException ignored) {
			System.err.println("Exception loading image for recipe: " + recipe.getName());
		}
		imageLabel.setToolTipText(recipe.getName());
		imageLabel.setLayout(new BorderLayout(0, 0));
		JLabel levelLabel = new JLabel("Lvl " + recipe.getLevel());
		Font defaultFont = imageLabel.getFont();
		levelLabel.setFont(new Font(defaultFont.getFontName(), Font.BOLD, 16));
		levelLabel.setBorder(new EmptyBorder(OSRSCalculator.TEXT_BORDER_SIZE, OSRSCalculator.TEXT_BORDER_SIZE, OSRSCalculator.TEXT_BORDER_SIZE, OSRSCalculator.TEXT_BORDER_SIZE));
		imageLabel.add(BorderLayout.NORTH, levelLabel);

		add(BorderLayout.CENTER, imageLabel);
		add(BorderLayout.SOUTH, this.xpLabel);
	}

	public void setXp(String xp) {
		this.xpLabel.setText(xp + "xp");
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(OSRSCalculator.OUTCOME_WIDTH, OSRSCalculator.RECIPEPANEL_HEIGHT);
	}
}
