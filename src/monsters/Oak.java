package monsters;

import bases.Monster;
import utils.Dice;

public class Oak extends Monster {
	public Oak(String name, String weapon) {
		super(name, weapon);
		
		int ohp = Dice.get(170, 230);
		super.setHp(ohp);
		
		int oofe = Dice.get(9, 15);
		super.setOffensive(oofe);
		}
	}
