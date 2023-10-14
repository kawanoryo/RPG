package humans;

import bases.Human;
import utils.Dice;

public class Brave extends Human {
	public Brave(String name, String weapon) {
		super(name, weapon);
		
		int bhp = Dice.get(170, 230);
		super.setHp(bhp);
		
		int bofe = Dice.get(7, 13);
		super.setOffensive(bofe);
		}
	}


