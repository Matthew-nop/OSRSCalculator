package nop.matthew.osrscalculator.ui;

import javax.swing.JPanel;
import javax.swing.Scrollable;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;

public class ScrollSkillPanel extends JPanel implements Scrollable {
	private final SkillPanel skillPanel;

	public ScrollSkillPanel(SkillPanel skillPanel) {
		super(new BorderLayout(0, 0));
		this.skillPanel = skillPanel;
		add(BorderLayout.CENTER, skillPanel);

		validate();
	}

	@Override
	public Dimension getPreferredScrollableViewportSize() {
		return skillPanel.getPreferredSize();
	}

	@Override
	public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
		return OSRSCalculator.RECIPEPANEL_HEIGHT;
	}

	@Override
	public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
		return OSRSCalculator.RECIPEPANEL_HEIGHT;
	}

	@Override
	public boolean getScrollableTracksViewportWidth() {
		return false;
	}

	@Override
	public boolean getScrollableTracksViewportHeight() {
		return false;
	}
}
