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

import nop.matthew.osrscalculator.data.Flags;

import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ItemEvent;

public class FlagsWindow extends JDialog {
	private final JPanel contentPanel;

	public FlagsWindow(Window window) {
		super(window);
		SkillPanel skillPanel = OSRSCalculator.calculator.getResultPanel().getCurrentPanel();
		GridLayout layoutManager = new GridLayout();
		this.contentPanel = new JPanel(layoutManager);
		setContentPane(this.contentPanel);
		setLayout(layoutManager);
		setModal(true);

		Flags[] flags = Flags.values();
		int count = 0;
		for (Flags flag : flags) {
			if (flag.getSkill().equals(skillPanel.getSkills())) {
				JCheckBox checkBox = new JCheckBox(flag.toString());
				checkBox.addItemListener(e -> {
					if (e.getStateChange() == ItemEvent.SELECTED)
						skillPanel.setFlag(flag);
					else
						skillPanel.unsetFlag(flag);
					skillPanel.update();
				});
				this.contentPanel.add(checkBox);
				count++;
			}
		}

		if (count == 0) {
			dispose();
			return;
		}

		layoutManager.setRows(2);
		layoutManager.setColumns(count / 2 + 1);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
