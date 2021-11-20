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
