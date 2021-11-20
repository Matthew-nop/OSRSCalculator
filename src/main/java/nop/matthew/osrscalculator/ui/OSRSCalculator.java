/*
 * Copyright 2021 Matthew C. <Chapman.L.Matthew@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nop.matthew.osrscalculator.ui;

import nop.matthew.osrscalculator.data.Skills;
import nop.matthew.osrscalculator.data.SortCriteria;
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

import javax.swing.JScrollPane;
import java.io.IOException;

public class OSRSCalculator {
	public static final int SKILL_ICON_LENGTH = 40;
	public static final int SKILL_COUNT = 11;
	public static final String DECIMAL_FORMAT_STRING = "#.#";

	/*
	Magic numbers for UI
	 */
	public static final int METHOD_SELECTION_HEIGHT = 40;
	public static final int METHOD_SELECTION_WIDTH = 160;
	public final static int RECIPEPANEL_HEIGHT = 70;
	public final static int OUTCOME_WIDTH = 100;
	public final static int COST_WIDTH = 100;
	public final static int VERTICAL_SCROLLBAR_WIDTH = (new JScrollPane()).getVerticalScrollBar().getPreferredSize().width;
	public final static int PROCESS_WIDTH_OFFSET = -(OUTCOME_WIDTH + COST_WIDTH + VERTICAL_SCROLLBAR_WIDTH);
	public static final int MINIMUM_WIDTH = SKILL_COUNT * SKILL_ICON_LENGTH;
	public static final int MINIMUM_HEIGHT = SKILL_ICON_LENGTH + METHOD_SELECTION_HEIGHT;

	/*
	Defaults for UI
	 */
	public static final int DEFAULT_WIDTH = MINIMUM_WIDTH;
	public static final int DEFAULT_HEIGHT = 600;
	public static final Skills DEFAULT_SKILL = Skills.HERBLORE;
	public static final SortCriteria DEFAULT_SORTCRITERIA = SortCriteria.LEVEL;

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
		calculator.openSwing(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}
