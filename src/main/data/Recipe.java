package data;

public interface Recipe {
	// returns array of output itemIDs
	// element order corresponds to coeff
	int[] getOutput();

	// returns array of coefficients "c" s.t. for each recipe action
	// profit = dot(price(ids), c)
	float[] getOutputCoeff(int flag);

	// returns array of ingredients
	Ingredient[] getIngredients();

	int getLevel();

	float getXp();
}
