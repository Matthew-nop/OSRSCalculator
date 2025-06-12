package data.herblore;

import data.Skill;
import net.PriceFetcher;

public class Herblore extends Skill {
	public Herblore(PriceFetcher priceFetcher) {
		super(priceFetcher);

		this.methodRecipes.put("Making Potions", Potions.values());
	}
}
