package monsters;

import bases.Monster;
import utils.Dice;

public class Slime extends Monster {
	public Slime(String name, String weapon) {
		super(name, weapon);
		
		int shp = Dice.get(70, 130);
		super.setHp(shp);
		
		int sofe = Dice.get(5, 11);
		super.setOffensive(sofe);
		}
	}

