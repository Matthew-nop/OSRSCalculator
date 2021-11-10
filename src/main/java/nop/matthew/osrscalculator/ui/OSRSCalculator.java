package nop.matthew.osrscalculator.ui;

import nop.matthew.osrscalculator.data.construction.Construction;
import nop.matthew.osrscalculator.data.cooking.Cooking;
import nop.matthew.osrscalculator.data.crafting.Crafting;
import nop.matthew.osrscalculator.data.farming.Farming;
import nop.matthew.osrscalculator.data.firemaking.Firemaking;
import nop.matthew.osrscalculator.data.fletching.Fletching;
import nop.matthew.osrscalculator.data.herblore.Herblore;
import nop.matthew.osrscalculator.data.hunter.Hunter;
import nop.matthew.osrscalculator.data.magic.Magic;
import nop.matthew.osrscalculator.data.prayer.Prayer;
import nop.matthew.osrscalculator.data.smithing.Smithing;
import nop.matthew.osrscalculator.net.PriceFetcher;

import java.io.IOException;

public class OSRSCalculator {
	public static final int SKILL_ICON_LENGTH = 40;
	public static final int SKILL_COUNT = 11;
	
	public static final int METHOD_SELECTION_HEIGHT = 40;
	public static final int METHOD_SELECTION_WIDTH = 160;
	public static final int DEFAULT_RESULTPANEL_HEIGHT = 400;

	public static final int MINIMUM_WIDTH = SKILL_COUNT * SKILL_ICON_LENGTH;
	public static final int MINIMUM_HEIGHT = SKILL_ICON_LENGTH + METHOD_SELECTION_HEIGHT;

	protected static Calculator calculator;

	public static void main(String[] args) throws IOException {
		PriceFetcher priceFetcher = new PriceFetcher();

		Construction construction = new Construction(priceFetcher);
		Cooking cooking = new Cooking(priceFetcher);
		Crafting crafting = new Crafting(priceFetcher);
		Farming farming = new Farming(priceFetcher);
		Firemaking firemaking = new Firemaking(priceFetcher);
		Fletching fletching = new Fletching(priceFetcher);
		Herblore herblore = new Herblore(priceFetcher);
		Hunter hunter = new Hunter(priceFetcher);
		Magic magic = new Magic(priceFetcher);
		Prayer prayer = new Prayer(priceFetcher);
		Smithing smithing = new Smithing(priceFetcher);

		construction.addRecipePrices();
		cooking.addRecipePrices();
		crafting.addRecipePrices();
		farming.addRecipePrices();
		firemaking.addRecipePrices();
		fletching.addRecipePrices();
		herblore.addRecipePrices();
		hunter.addRecipePrices();
		magic.addRecipePrices();
		prayer.addRecipePrices();
		smithing.addRecipePrices();

		priceFetcher.updatePrices();
		calculator = new Calculator();
		calculator.addSkill(construction);
		calculator.addSkill(cooking);
		calculator.addSkill(crafting);
		calculator.addSkill(farming);
		calculator.addSkill(firemaking);
		calculator.addSkill(fletching);
		calculator.addSkill(herblore);
		calculator.addSkill(hunter);
		calculator.addSkill(magic);
		calculator.addSkill(prayer);
		calculator.addSkill(smithing);

		openSwing();
	}

	public static void openSwing() {
		calculator.setup(MINIMUM_WIDTH, MINIMUM_HEIGHT, null);
		calculator.pack();
		calculator.setVisible(true);
	}
}
