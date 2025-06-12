package nop.matthew.osrscalculator.ui;

import nop.matthew.osrscalculator.data.Methods;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

public class SelectionPanel extends JPanel {
	private static final JPanel buttons = new JPanel(new GridLayout(1, 11)) {
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(OSRSCalculator.MINIMUM_WIDTH * this.getComponentCount(), OSRSCalculator.SKILL_ICON_LENGTH);
		}
	};
	private static final JComboBox<String> selectedMethod = new JComboBox<>() {
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(OSRSCalculator.METHOD_SELECTION_WIDTH, OSRSCalculator.METHOD_SELECTION_HEIGHT);
		}
	};

	public SelectionPanel() {
		super();
		setLayout(new BorderLayout(0, 0));
		selectedMethod.addActionListener(e -> {
			Object selected = selectedMethod.getSelectedItem();
			if (selected != null) {
				Calculator.getResultPanel().setMethod(Methods.getFromName(selected.toString()));
				Calculator.getResultPanel().sortBy(Calculator.getSortCriteria());
			}
			repaint();
			revalidate();
		});

		JPanel goalsPanel = new JPanel(new BorderLayout(0, 0));
		JTextField startBox = new JTextField();
		JTextField endBox = new JTextField();
		JPanel labelPanel = new JPanel(new BorderLayout(0, 0));
		labelPanel.add(BorderLayout.NORTH, new JLabel("Start: "));
		labelPanel.add(BorderLayout.SOUTH, new JLabel("Target: "));
		JPanel textBoxPanel = new JPanel(new BorderLayout(0, 0));
		textBoxPanel.add(BorderLayout.NORTH, startBox);
		textBoxPanel.add(BorderLayout.SOUTH, endBox);
		JButton goalsButton = new JButton("Update");
		goalsButton.addActionListener(e -> {
			int start, end;
			try {
				start = Integer.parseInt(startBox.getText());
				end = Integer.parseInt(endBox.getText());
			} catch (NumberFormatException exception) {
				return;
			}
			Calculator.getResultPanel().getCurrentPanel().updateActions(start, end, Calculator.goalIsLevel());
		});
		goalsPanel.add(BorderLayout.WEST, labelPanel);
		goalsPanel.add(BorderLayout.CENTER, textBoxPanel);
		goalsPanel.add(BorderLayout.EAST, goalsButton);

		JButton flagsButton = new JButton("Flags");
		flagsButton.addActionListener(e -> new FlagsWindow(SwingUtilities.getWindowAncestor(this)));

		add(BorderLayout.NORTH, buttons);
		add(BorderLayout.EAST, selectedMethod);
		add(BorderLayout.WEST, flagsButton);
		add(BorderLayout.CENTER, goalsPanel);
		setMinimumSize(getMinimumSize());
	}

	/**
	 * Add a button to the panel for selecting skills
	 *
	 * @param button the button to add
	 */
	public static void addSkillButton(JButton button) {
		button.setMinimumSize(new Dimension(OSRSCalculator.SKILL_ICON_LENGTH, OSRSCalculator.SKILL_ICON_LENGTH));
		buttons.add(button);
	}

	/**
	 * Set the list of methods which the filter combobox should display
	 *
	 * @param methods The list of methods
	 */
	public static void setMethods(List<Methods> methods) {
		selectedMethod.removeAllItems();
		selectedMethod.addItem("All");
		for (Methods method : methods) {
			selectedMethod.addItem(method.getName());
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(OSRSCalculator.calculator.getWidth(), this.getMinimumSize().height);
	}

	@Override
	public Dimension getMinimumSize() {
		return new Dimension(OSRSCalculator.MINIMUM_WIDTH, buttons.getPreferredSize().height + selectedMethod.getPreferredSize().height);
	}
}
