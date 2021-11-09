package nop.matthew.osrscalculator.ui;

import nop.matthew.osrscalculator.data.Methods;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

// TODO: the selected method should filter the shown recipes
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
		Dimension buttonsSize = new Dimension(Calculator.MINIMUM_WIDTH, Calculator.SKILL_ICON_LENGTH);
		this.buttons.setMinimumSize(buttonsSize);
		add(BorderLayout.NORTH, buttons);

		this.selectedMethod.setMinimumSize(new Dimension(Calculator.METHOD_SELECTION_WIDTH, Calculator.METHOD_SELECTION_HEIGHT));
		add(BorderLayout.EAST, selectedMethod);

		setLocation(0, 0);
		Dimension size = new Dimension(Calculator.MINIMUM_WIDTH, Calculator.SKILL_ICON_LENGTH + Calculator.METHOD_SELECTION_HEIGHT);
		setMinimumSize(size);
		setPreferredSize(size);
		setVisible(true);
	}

	public void addButton(JButton button) {
		Dimension size = new Dimension(Calculator.SKILL_ICON_LENGTH, Calculator.SKILL_ICON_LENGTH);
		button.setMinimumSize(size);
		button.setMaximumSize(size);
		button.setPreferredSize(size);
		buttons.add(button);
	}

	public void setMethods(List<Methods> methods) {
		this.selectedMethod.removeAllItems();
		for (Methods method : methods) {
			this.selectedMethod.addItem(method.getName());
		}
	}
}
