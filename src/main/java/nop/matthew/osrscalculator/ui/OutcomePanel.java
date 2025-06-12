package nop.matthew.osrscalculator.ui;

import nop.matthew.osrscalculator.data.Recipe;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class OutcomePanel extends JPanel {

	public OutcomePanel(Recipe recipe) {
		super(new BorderLayout(0, 0));
		
		add(BorderLayout.CENTER, new JLabel(recipe.getName())); // TODO: place an image
		add(BorderLayout.SOUTH, new JLabel(recipe.getLevel() + " - " + recipe.getXp()));
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(OSRSCalculator.OUTCOME_WIDTH, OSRSCalculator.RECIPEPANEL_HEIGHT);
	}
}
