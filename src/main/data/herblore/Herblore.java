package data.herblore;

import data.Skill;
import net.PriceFetcher;

public class Herblore extends Skill {
	public Herblore(PriceFetcher priceFetcher) {
		super(priceFetcher, "Herblore");
		this.methodRecipes.put("Making Potions", Potions.values());
	}
}
