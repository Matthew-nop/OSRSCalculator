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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

public class SelectionPanel extends JPanel {
	private final JPanel buttons;
	private final JComboBox<String> selectedMethod;

	public SelectionPanel() {
		super();
		setLayout(new BorderLayout(0, 0));
		this.buttons = new JPanel(new GridLayout(1, 11));
		this.selectedMethod = new JComboBox<>();
	}

	public void setup() {
		Dimension buttonsSize = new Dimension(OSRSCalculator.MINIMUM_WIDTH, OSRSCalculator.SKILL_ICON_LENGTH);
		this.buttons.setPreferredSize(buttonsSize);
		add(BorderLayout.NORTH, buttons);

		this.selectedMethod.setPreferredSize(new Dimension(OSRSCalculator.METHOD_SELECTION_WIDTH, OSRSCalculator.METHOD_SELECTION_HEIGHT));
		add(BorderLayout.EAST, selectedMethod);

		setMinimumSize(new Dimension(OSRSCalculator.MINIMUM_WIDTH, this.buttons.getPreferredSize().height + this.selectedMethod.getPreferredSize().height));
		setVisible(true);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Math.max(this.getWidth(), this.getMinimumSize().width), this.getMinimumSize().height);
	}

	public JComboBox<String> getSelectedMethod() {
		return selectedMethod;
	}

	/** Add a button to the panel for selecting skills
	 *
	 * @param button the button to add
	 */
	public void addButton(JButton button) {
		button.setMinimumSize(new Dimension(OSRSCalculator.SKILL_ICON_LENGTH, OSRSCalculator.SKILL_ICON_LENGTH));
		buttons.add(button);
	}

	/** Set the list of methods which the filter combobox should display
	 *
	 * @param methods The list of methods
	 */
	public void setMethods(List<Methods> methods) {
		this.selectedMethod.removeAllItems();
		selectedMethod.addItem("All");
		for (Methods method : methods) {
			this.selectedMethod.addItem(method.getName());
		}
	}
}
