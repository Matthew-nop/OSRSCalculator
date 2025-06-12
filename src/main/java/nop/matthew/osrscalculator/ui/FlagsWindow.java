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
import java.net.URL;

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
					URL flagPath = flag.getIconPath();
					if(flagPath != null) {
						flagIcon = new JLabel(new ImageIcon(ImageIO.read(flagPath)));
					}
					else {
						flagIcon = new JLabel();
					}
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
			setMinimumSize(getMinimumSize());
			pack();
			setLocationRelativeTo(null);
			setVisible(true);
		}
	}

	@Override
	public Dimension getMinimumSize() {
		return new Dimension(OSRSCalculator.FLAG_DIALOG_MIN_WIDTH, OSRSCalculator.FLAG_DIALOG_MIN_HEIGHT);
	}
}
