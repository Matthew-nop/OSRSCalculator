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

	public void addButton(JButton button) {
		button.setMinimumSize(new Dimension(OSRSCalculator.SKILL_ICON_LENGTH, OSRSCalculator.SKILL_ICON_LENGTH));
		buttons.add(button);
	}

	public void setMethods(List<Methods> methods) {
		this.selectedMethod.removeAllItems();
		selectedMethod.addItem("All");
		for (Methods method : methods) {
			this.selectedMethod.addItem(method.getName());
		}
	}
}
