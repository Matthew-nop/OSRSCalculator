package nop.matthew.osrscalculator.ui;

import nop.matthew.osrscalculator.data.Methods;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

public class SelectionPanel extends JPanel {
	private final JPanel buttons;
	private final JComboBox<String> selectedMethod;
	private final JButton flagsButton;

	public SelectionPanel() {
		super();
		setLayout(new BorderLayout(0, 0));
		this.buttons = new JPanel(new GridLayout(1, 11)) {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(OSRSCalculator.MINIMUM_WIDTH * this.getComponentCount(), OSRSCalculator.SKILL_ICON_LENGTH);
			}
		};
		this.selectedMethod = new JComboBox<>() {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(OSRSCalculator.METHOD_SELECTION_WIDTH, OSRSCalculator.METHOD_SELECTION_HEIGHT);
			}
		};
		this.flagsButton = new JButton("Flags");
		this.flagsButton.addActionListener(e -> new FlagsWindow(SwingUtilities.getWindowAncestor(this)));
	}

	public void setup() {
		add(BorderLayout.NORTH, buttons);
		add(BorderLayout.EAST, selectedMethod);
		add(BorderLayout.WEST, this.flagsButton);

		setMinimumSize(getMinimumSize());
		setVisible(true);
	}

	public JComboBox<String> getSelectedMethod() {
		return selectedMethod;
	}

	/**
	 * Add a button to the panel for selecting skills
	 *
	 * @param button the button to add
	 */
	public void addSkillButton(JButton button) {
		button.setMinimumSize(new Dimension(OSRSCalculator.SKILL_ICON_LENGTH, OSRSCalculator.SKILL_ICON_LENGTH));
		buttons.add(button);
	}

	/**
	 * Set the list of methods which the filter combobox should display
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

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(OSRSCalculator.calculator.getWidth(), this.getMinimumSize().height);
	}

	@Override
	public Dimension getMinimumSize() {
		return new Dimension(OSRSCalculator.calculator.getMinimumSize().width, this.buttons.getPreferredSize().height + this.selectedMethod.getPreferredSize().height);
	}
}
