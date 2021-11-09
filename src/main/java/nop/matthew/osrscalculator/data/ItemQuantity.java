package nop.matthew.osrscalculator.data;

public class ItemQuantity {
	private final Item item;
	private final float quantity;

	public ItemQuantity(Item item, float quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	public String getName() {
		return this.item.toString();
	}

	public int getId() {
		return this.item.getId();
	}

	public float getQuantity() {
		return this.quantity;
	}
}
