package monsters;

import bases.Monster;
import utils.Dice;

public class Dragon extends Monster {
	public Dragon(String name, String weapon) {
		super(name, weapon);
		
		int dhp = Dice.get(270, 330);
		super.setHp(dhp);
		
		int dofe = Dice.get(12, 18);
		super.setOffensive(dofe);
		}
	}
