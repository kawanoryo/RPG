package humans;

import bases.Human;
import utils.Dice;

public class Fighter extends Human {
	public Fighter(String name, String weapon) {
		super(name, weapon);
		
		int fhp = Dice.get(240, 300);
		super.setHp(fhp);
		
		int fofe = Dice.get(17, 23);
		super.setOffensive(fofe);
		}
	}

