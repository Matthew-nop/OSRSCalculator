package nop.matthew.osrscalculator.data;

import java.util.Set;

public interface Recipe {
	int[] getOutput();  // TODO: after id, idAmulet in data.herblore.Potion are refactored to item, this needs to return item[]

	Item[] getIngredients();

	int getLevel();

	float getXp();

	boolean flagsAffect(Set<Flags> flag);

	boolean flagsAffect(Flags flag);
}
