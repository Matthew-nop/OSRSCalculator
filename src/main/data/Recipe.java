package data;

public interface Recipe {
	int[] getOutput();

	Item[] getIngredients();

	int getLevel();

	float getXp();
}
