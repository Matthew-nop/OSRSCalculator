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
				JCheckBox checkBox = new JCheckBox(flag.toString(), skillPanel.checkFlag(flag));
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
