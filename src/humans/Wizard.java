package humans;

import bases.Human;
import utils.Dice;

public class Wizard extends Human {
	public Wizard(String name, String weapon) {
		super(name, weapon);
		
		int whp = Dice.get(120, 180);
		super.setHp(whp);
		
		int wofe = Dice.get(12, 18);
		super.setOffensive(wofe);
		}
	}

