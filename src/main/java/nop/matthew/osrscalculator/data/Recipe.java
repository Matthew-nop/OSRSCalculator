package nop.matthew.osrscalculator.data;

import java.util.Set;

public interface Recipe {
	ItemQuantity[] getOutput();

	ItemQuantity[] getIngredients();

	String getName();

	int getLevel();

	float getXp();

	boolean flagsAffect(Set<Flags> flag);

	boolean flagsAffect(Flags flag);
}
