package data;

public class Item {
	private final int id;
	private final float quantity;

	public Item(int id, float quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public int getId() {
		return this.id;
	}

	public float getQuantity() {
		return this.quantity;
	}
}
