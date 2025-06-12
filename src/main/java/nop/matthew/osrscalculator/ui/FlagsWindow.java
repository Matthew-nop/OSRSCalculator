package nop.matthew.osrscalculator.ui;

import nop.matthew.osrscalculator.data.Flags;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ItemEvent;
import java.io.IOException;

public class FlagsWindow extends JDialog {
	public FlagsWindow(Window window) {
		super(window);
		SkillPanel skillPanel = ResultPanel.getInstance().getCurrentPanel();
		GridLayout layoutManager = new GridLayout(0, 2);
		JPanel contentPanel = new JPanel(layoutManager);
		setContentPane(contentPanel);
		setLayout(layoutManager);
		setResizable(false);
		setModal(true);

		Flags[] flags = Flags.values();
		int count = 0;
		for (Flags flag : flags) {
			if (flag.getSkill().equals(skillPanel.getSkills())) {
				JCheckBox checkBox = new JCheckBox(flag.toString(), skillPanel.checkFlag(flag));
				checkBox.addItemListener(e -> {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						skillPanel.setFlag(flag);
					}
					else {
						skillPanel.unsetFlag(flag);
					}
					skillPanel.updateCosts();
				});
				JLabel flagIcon;
				try {
					flagIcon = new JLabel(new ImageIcon(ImageIO.read(flag.getIconPath())));
				} catch (IOException e) {
					e.printStackTrace();
					flagIcon = new JLabel();
				}
				contentPanel.add(flagIcon);
				contentPanel.add(checkBox);
				count++;
			}
		}

		if (count == 0) {
			dispose();
		}
		else {
			pack();
			setLocationRelativeTo(null);
			setVisible(true);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(
				Math.max(OSRSCalculator.FLAG_DIALOG_MIN_WIDTH, getWidth()),
				Math.max(OSRSCalculator.FLAG_DIALOG_MIN_HEIGHT, getHeight()));
	}
}
