package nop.matthew.osrscalculator.ui;

import nop.matthew.osrscalculator.data.construction.Construction;
import nop.matthew.osrscalculator.data.herblore.Herblore;
import nop.matthew.osrscalculator.net.PriceFetcher;

import java.io.IOException;

public class OSRSCalculator {
	public static final int DEFAULT_APP_WIDTH = Calculator.MINIMUM_WIDTH;
	public static final int DEFAULT_APP_HEIGHT = Calculator.MINIMUM_HEIGHT + 500;

	public static final int SKILL_COUNT = 11;

	public static void main(String[] args) throws IOException {
		PriceFetcher priceFetcher = new PriceFetcher();

		Herblore herblore = new Herblore(priceFetcher);
		Construction construction = new Construction(priceFetcher);


		herblore.addRecipePrices();
		construction.addRecipePrices();

		priceFetcher.updatePrices();

		Calculator calculator = new Calculator();
		/*
		Until all skills are implemented, add an
		equal amount of buttons using duplicate skills
		 */
		calculator.addSkill(construction);
		calculator.addSkill(herblore);
		calculator.addSkill(herblore);
		calculator.addSkill(herblore);
		calculator.addSkill(herblore);
		calculator.addSkill(herblore);
		calculator.addSkill(herblore);
		calculator.addSkill(herblore);
		calculator.addSkill(herblore);
		calculator.addSkill(herblore);
		calculator.addSkill(herblore);

		calculator.openSwing(DEFAULT_APP_WIDTH, DEFAULT_APP_HEIGHT);
	}
}
