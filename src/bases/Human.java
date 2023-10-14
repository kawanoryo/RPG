package bases;

import utils.Dice;

//人間を表現する抽象クラス
public abstract class Human extends Living {

	// コンストラクタ
	public Human(String name, String weapon) {
		// Livingクラスで定義したコンストラクタを利用する
		super(name, weapon);
	}

	// attackメソッドのオーバーライド
	@Override
	public void attack(Living target) {
		
		
		// 1から10までのサイコロを振り、自分の攻撃力とかけ合わせた値を相手に与えるダメージとする
		int ofe = super.getOffensive();		
		int dam = ( Dice.get(1, 10) * ofe );

		// 相手のHPをダメージ値だけ減らす
		int ehp = target.getHp() - dam;
		target.setHp(ehp);
		

		// 自分の攻撃力を1だけ減らす
		int aofe = super.getOffensive() - 1;
		super.setOffensive(aofe);

		// コンソールにステータスを表示
		System.out.println(super.getName() + "が" + super.getWeapon() + "で攻撃！" + target.getName() + "に" + dam + "のダメージを与えた。"
				+"しかし自身の攻撃力も1減少した");
		

	}
}