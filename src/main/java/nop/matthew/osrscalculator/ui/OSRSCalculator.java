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

import javax.swing.JScrollPane;
import java.io.IOException;

public class OSRSCalculator {
	public static final int SKILL_ICON_LENGTH = 40;
	public static final int SKILL_COUNT = 11;
	public static final String DECIMAL_FORMAT_STRING = "#.#";

	/*
	Magic numbers for UI
	 */
	public static final int METHOD_SELECTION_WIDTH = 140;
	public static int METHOD_SELECTION_HEIGHT = 40;
	public static final int RECIPE_IMAGE_SIZE = 64;
	public static final int RECIPEPANEL_HEIGHT = RECIPE_IMAGE_SIZE + 20;
	public static final int OUTCOME_WIDTH = RECIPE_IMAGE_SIZE;
	public static final int EFFICIENCY_WIDTH = 120;
	public static final int VERTICAL_SCROLLBAR_WIDTH = (new JScrollPane()).getVerticalScrollBar().getPreferredSize().width;
	public static final int PROCESS_WIDTH_OFFSET = -(OUTCOME_WIDTH + EFFICIENCY_WIDTH + VERTICAL_SCROLLBAR_WIDTH);
	public static final int MINIMUM_WIDTH = SKILL_COUNT * SKILL_ICON_LENGTH;
	public static final int MINIMUM_HEIGHT = SKILL_ICON_LENGTH + METHOD_SELECTION_HEIGHT;
	public static final int TEXT_BORDER_SIZE = 3;
	public static final int FLAG_DIALOG_MIN_WIDTH = 200;
	public static final int FLAG_DIALOG_MIN_HEIGHT = 100;

	/*
	Defaults for UI
	 */
	public static final int DEFAULT_WIDTH = MINIMUM_WIDTH;
	public static final int DEFAULT_HEIGHT = 600;
	public static final Skills DEFAULT_SKILL = Skills.HERBLORE;
	public static final SortCriteria DEFAULT_SORTCRITERIA = SortCriteria.LEVEL;
	public static final boolean GOAL_IS_LEVEL_DEFAULT = true;
	public static final boolean AUTOUPDATE_PRICES_DEFAULT = true;
	public static final int AUTOUPDATE_WAIT_MS = 60 * 1000;

	public static void main(String[] args) throws IOException {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("mac")) {
			METHOD_SELECTION_HEIGHT += 10;
		}

		Construction construction = Construction.getInstance();
		Cooking cooking = Cooking.getInstance();
		Crafting crafting = Crafting.getInstance();
		Farming farming = Farming.getInstance();
		Firemaking firemaking = Firemaking.getInstance();
		Fletching fletching = Fletching.getInstance();
		Herblore herblore = Herblore.getInstance();
		Hunter hunter = Hunter.getInstance();
		Magic magic = Magic.getInstance();
		Prayer prayer = Prayer.getInstance();
		Smithing smithing = Smithing.getInstance();

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

		Calculator calculator = Calculator.getInstance();
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

		calculator.start(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}
