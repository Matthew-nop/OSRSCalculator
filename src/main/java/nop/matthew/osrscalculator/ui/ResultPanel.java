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
		this.cardLayout = (CardLayout) getLayout();
		this.skillPanels = new HashMap<>(OSRSCalculator.SKILL_COUNT);
		this.lastHeight = OSRSCalculator.DEFAULT_RESULTPANEL_HEIGHT;
	}

	/** Add the given SkillPanel to the panel
	 *
	 * @param skillPanel the SkillPanel to add
	 * @return the added SkillPanel
	 */
	public Component add(SkillPanel skillPanel) {
		super.add(skillPanel.getSkills().toString(), skillPanel.getScrollPane());
		this.skillPanels.put(skillPanel.getSkills(), skillPanel);
		return skillPanel;
	}

	/** Set the active skill which is displayed
	 *
	 * @param skills the skill to change to. If null, the panel is hidden.
	 */
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

	/** Set the method by which the active skill's recipes will be filtered
	 *
	 * @param method the method to filter by
	 */
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
