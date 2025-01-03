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

package nop.matthew.osrscalculator.data;

import nop.matthew.osrscalculator.ui.RecipePanel;

import java.util.Comparator;

public enum SortCriteria {
	LEVEL("Level"),
	NORMALISED_COST("GP/XP"),
	PROFIT("Profit"),
	NAME("Name"),
	;

	private final String name;

	SortCriteria(String name) {
		this.name = name;
	}

	/**
	 * Returns a comparator for the given SortCriteria
	 *
	 * @param sortType the given SortCriteria
	 * @return a Comparator for the given criteria
	 */
	public static Comparator<RecipePanel> getComparator(SortCriteria sortType) {
		return switch (sortType) {
			case LEVEL -> Comparator
					.comparing((RecipePanel rp) -> rp.getRecipe().getLevel())
					.thenComparing((RecipePanel rp) -> rp.getRecipe().getXp());
			case NORMALISED_COST -> Comparator
					.comparing(RecipePanel::getNormalisedProfit)
					.thenComparing(RecipePanel::getProfit)
					.reversed();
			case PROFIT -> Comparator
					.comparing(RecipePanel::getProfit)
					.thenComparing(RecipePanel::getNormalisedProfit)
					.reversed();
			case NAME ->
					(rp1, rp2) -> String.CASE_INSENSITIVE_ORDER.compare(rp1.getRecipe().getName(), rp2.getRecipe().getName());
			default -> null;
		};
	}

	/**
	 * Returns the first SortCriteria which matches the given name
	 *
	 * @param name the given name
	 * @return the first matching SortCriteria
	 */
	public static SortCriteria getFromName(String name) {
		for (SortCriteria t : SortCriteria.values()) {
			if (t.toString().equals(name)) {
				return t;
			}
		}

		return null;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
