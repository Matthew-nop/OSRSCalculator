/*
 * Copyright 2021 Matthew C. <Chapman.L.Matthew@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
