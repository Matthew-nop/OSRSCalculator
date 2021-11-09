package ui;

import data.Skill;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

public class Calculator {
	public static final int SKILL_ICON_LENGTH = 40;
	public static final int METHOD_SELECTION_WIDTH = 160;
	public static final int METHOD_SELECTION_HEIGHT = 40;
	public static final int MINIMUM_WIDTH = OSRSCalculator.SKILL_COUNT * SKILL_ICON_LENGTH;
	public static final int MINIMUM_HEIGHT = SKILL_ICON_LENGTH + METHOD_SELECTION_HEIGHT;

	private final JFrame mainFrame;
	private final BorderLayout mainLayout;
	private final SelectionPanel selectionPanel;
	private final JPanel resultPanel;

	public Calculator() {
		this.mainFrame = new JFrame("OSRS Calculator");
		this.mainLayout = new BorderLayout(0, 0);
		this.mainFrame.setUndecorated(true);
		this.mainFrame.setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		this.selectionPanel = new SelectionPanel();
		this.resultPanel = new JPanel(new CardLayout());
	}

	public void openSwing(int width, int height) {
		// Set up the main frame
		setup();
		this.mainFrame.setPreferredSize(new Dimension(width, height));

		// Set up the selection panel
		this.mainFrame.add(BorderLayout.NORTH, this.selectionPanel);
		this.selectionPanel.setup();

		// Set up the skills panel
		this.mainFrame.add(BorderLayout.CENTER, resultPanel);
		this.resultPanel.setVisible(true);

		// Finish
		this.mainFrame.setVisible(true);
	}

	private void setup() {
		this.mainFrame.setLayout(this.mainLayout);
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setResizable(true);
	}

	public void addSkill(Skill skill) throws IOException {
		String key = skill.getKey();

		SkillPanel panel = new SkillPanel(skill);
		this.resultPanel.add(key, panel.getScrollPane());

		JButton button = new JButton(new ImageIcon(ImageIO
				.read(new File("res/SkillIcons/" + key.toLowerCase() + ".png"))
				.getScaledInstance(SKILL_ICON_LENGTH, SKILL_ICON_LENGTH, Image.SCALE_DEFAULT)));
		button.setToolTipText(key);
		button.addActionListener(e -> {
			System.out.println("Selected calculator panel for " + key);
			panel.update();
			this.selectionPanel.setMethods(skill.getMethodRecipes().keySet().toArray(new String[]{}));
			CardLayout layout = (CardLayout) (resultPanel.getLayout());
			layout.show(resultPanel, key);
		});
		this.selectionPanel.addButton(button);
	}
}
