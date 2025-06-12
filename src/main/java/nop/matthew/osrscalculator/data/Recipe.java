package nop.matthew.osrscalculator.data;

import java.util.Set;

public interface Recipe {
	int[] getOutput();

	Item[] getIngredients();

	int getLevel();

	float getXp();

	boolean flagsAffect(Set<Flags> flag);

	boolean flagsAffect(Flags flag);
}
