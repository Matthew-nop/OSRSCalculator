package nop.matthew.osrscalculator.data;

import java.net.URL;
import java.util.Set;

public interface Recipe {
	/**
	 * Get an array of this recipe's outputs
	 *
	 * @return the array of outputs
	 */
	ItemQuantity[] getOutput();

	/**
	 * Get an array of this recipe's ingredients
	 *
	 * @return the array of ingredients
	 */
	ItemQuantity[] getIngredients();

	/**
	 * Get the name of this recipe
	 *
	 * @return the name
	 */
	String getName();

	/**
	 * Get the required level for this recipe
	 *
	 * @return the required level
	 */
	int getLevel();

	/**
	 * Get the xp gained for one recipe action
	 *
	 * @return the xp gained
	 */
	float getXp();

	/**
	 * Check if any of the given flags affect this recipe
	 *
	 * @param flag the given flags
	 * @return true if this recipe is affected, false if not
	 */
	boolean flagAffects(Set<Flags> flag);

	/**
	 * Check if the given flag affects this recipe;
	 *
	 * @param flag the given flag
	 * @return true if this recipe is affected, false if not
	 */
	boolean flagAffects(Flags flag);

	/**
	 * Get the filepath for the given recipe's icon
	 *
	 * @return the filepath
	 */
	URL getIconPath();
}
