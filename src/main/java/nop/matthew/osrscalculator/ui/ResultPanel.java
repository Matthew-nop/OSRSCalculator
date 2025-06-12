package nop.matthew.osrscalculator.ui;

import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Skills;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.HashMap;

class ResultPanel extends JPanel {
	Skills activeSkills;
	CardLayout cardLayout;
	HashMap<Skills, SkillPanel> skillPanels;
	int lastHeight;

	public ResultPanel() {
		super(new CardLayout(0, 0));
		this.cardLayout = (CardLayout) super.getLayout();
		this.skillPanels = new HashMap<>(OSRSCalculator.SKILL_COUNT);
		this.lastHeight = OSRSCalculator.DEFAULT_RESULTPANEL_HEIGHT;
	}

	public Component add(String string, SkillPanel skillPanel) {
		super.add(string, skillPanel.getScrollPane());
		this.skillPanels.put(skillPanel.getSkills(), skillPanel);
		return skillPanel;
	}

	public void setActiveSkills(Skills skills) {
		if (skills != null && !skills.equals(this.activeSkills)) {
			SkillPanel currentPanel = skillPanels.get(skills);
			if (currentPanel != null)
				currentPanel.update();
			this.cardLayout.show(this, skills.toString());
			this.activeSkills = skills;
			setVisible(true);
		}
		else {
			// If the panel hasn't been set up, ignore
			if (this.getWidth() > 0)
				this.lastHeight = getHeight();
			this.cardLayout.show(this, null);
			this.activeSkills = null;
			setVisible(false);
		}
	}

	public void setMethod(Methods method) {
		if (activeSkills != null)
			skillPanels.get(activeSkills).setMethod(method);
	}

	public Skills getActiveSkills() {
		return activeSkills;
	}

	@Override
	public Dimension getPreferredSize() {
		return isVisible() ?
				new Dimension(OSRSCalculator.calculator.getWidth(), lastHeight) :
				new Dimension(OSRSCalculator.calculator.getWidth(), 0);
	}
}
