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
	private static SelectionPanel selectionPanel = null;
	private final JPanel buttons = new JPanel(new GridLayout(1, 11)) {
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(OSRSCalculator.MINIMUM_WIDTH * this.getComponentCount(), OSRSCalculator.SKILL_ICON_LENGTH);
		}
	};
	private final JComboBox<String> selectedMethod = new JComboBox<>() {
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(OSRSCalculator.METHOD_SELECTION_WIDTH, OSRSCalculator.METHOD_SELECTION_HEIGHT);
		}
	};
	private final JTextField startBox = new JTextField();
	private final JTextField endBox = new JTextField();
	private final JButton goalsButton = new JButton("Update");

	private SelectionPanel() {
		super();
		setLayout(new BorderLayout(0, 0));

		// Set up the goals panel
		JPanel goalsPanel = new JPanel(new BorderLayout(0, 0));
		JPanel labelPanel = new JPanel(new BorderLayout(0, 0));
		labelPanel.add(BorderLayout.NORTH, new JLabel("Start: "));
		labelPanel.add(BorderLayout.SOUTH, new JLabel("Target: "));
		JPanel textBoxPanel = new JPanel(new BorderLayout(0, 0));
		textBoxPanel.add(BorderLayout.NORTH, startBox);
		textBoxPanel.add(BorderLayout.SOUTH, endBox);
		goalsPanel.add(BorderLayout.WEST, labelPanel);
		goalsPanel.add(BorderLayout.CENTER, textBoxPanel);
		goalsPanel.add(BorderLayout.EAST, goalsButton);

		// Set up the flags button
		JButton flagsButton = new JButton("Flags");
		flagsButton.addActionListener(e -> new FlagsWindow(SwingUtilities.getWindowAncestor(this)));

		// Finish
		add(BorderLayout.NORTH, buttons);
		add(BorderLayout.EAST, selectedMethod);
		add(BorderLayout.WEST, flagsButton);
		add(BorderLayout.CENTER, goalsPanel);
		setMinimumSize(getMinimumSize());
	}

	synchronized public static SelectionPanel getInstance() {
		if (selectionPanel == null) {
			selectionPanel = new SelectionPanel();
		}
		return selectionPanel;
	}

	public void setup() {
		Calculator calculator = Calculator.getInstance();
		ResultPanel resultPanel = ResultPanel.getInstance();
		selectedMethod.addActionListener(e -> {
			Object selected = selectedMethod.getSelectedItem();
			if (selected != null) {
				resultPanel.setMethod(Methods.getFromName(selected.toString()));
				resultPanel.sortBy(calculator.getSortCriteria());
			}
			repaint();
			revalidate();
		});
		goalsButton.addActionListener(e -> {
			int start, end;
			try {
				start = Integer.parseInt(startBox.getText());
				end = Integer.parseInt(endBox.getText());
			} catch (NumberFormatException exception) {
				return;
			}
			resultPanel.getCurrentPanel().updateActions(start, end, calculator.goalIsLevel());
		});
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
		selectedMethod.removeAllItems();
		selectedMethod.addItem("All");
		for (Methods method : methods) {
			selectedMethod.addItem(method.getName());
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Calculator.getInstance().getWidth(), this.getMinimumSize().height);
	}

	@Override
	public Dimension getMinimumSize() {
		return new Dimension(OSRSCalculator.MINIMUM_WIDTH, buttons.getPreferredSize().height + selectedMethod.getPreferredSize().height);
	}
}
