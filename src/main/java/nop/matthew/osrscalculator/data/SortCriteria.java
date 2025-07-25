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
