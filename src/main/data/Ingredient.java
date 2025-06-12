package data;

public class Ingredient {
	private final int id;
	private final int quantity;

	public Ingredient(int id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public int getId() {
		return this.id;
	}

	public int getQuantity() {
		return this.quantity;
	}
}
