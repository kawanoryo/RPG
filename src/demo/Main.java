package demo;

import java.util.ArrayList;
import java.util.List;

import bases.Human;
import bases.Monster;
import humans.Brave;
import humans.Fighter;
import humans.Wizard;
import monsters.Dragon;
import monsters.Oak;
import monsters.Slime;
import utils.Dice;

public class Main {
	public static void main(String[] args) {

		System.out.println("★★ ==== 戦いの開始だ！！ ==== ★★");

		// Brave（勇者）, Fighter（戦士）, Wizard（魔法使い）クラスの各インスタンスを生成

		Human humans1 = new Brave("沖田総司", "剣");
		Human humans2 = new Fighter("坂田金時", "斧");
		Human humans3 = new Wizard("安倍晴明", "魔法");

		// 人間グループのリストを空で生成
		List<Human> humans = new ArrayList<>();

		// 勇者、戦士、魔法使いを人間グループのリストに追加
		humans.add(humans1);
		humans.add(humans2);
		humans.add(humans3);

		// Slime（スライム）, Oak（オーク）, Dragon（ドラゴン）クラスの各インスタンスを生成
		Monster monsters1 = new Slime("キングスライム", "体当たり");
		Monster monsters2 = new Oak("オークキング", "斧");
		Monster monsters3 = new Dragon("紅龍", "炎");

		// モンスターグループのリストを空で生成
		List<Monster> monsters = new ArrayList<>();

		// スライム、オーク、ドラゴンをモンスターグループのリストに追加
		monsters.add(monsters1);
		monsters.add(monsters2);
		monsters.add(monsters3);

		// 現在の各グループの状態を一覧表示
		showGroupInfos(humans, monsters);

		// 第何回戦かを示すカウンター変数
		int count = 1;

		// 勝敗がつくまで無限ループ
		while (true) {

			System.out.printf("\n★ 第%d回戦 ==========\n", count);

			System.out.println("\n[人間のターン！]\n");

			// 人間グループから1人選択
			Human select_human = humans.get(Dice.get(0, humans.size() - 1));

			// モンスターグループから1人選択
			Monster select_monster = monsters.get(Dice.get(0, monsters.size() - 1));

			// 選ばれた人間が、選ばれたモンスターを攻撃
			select_human.attack(select_monster);

			// モンスターのHPが0以下になれば、モンスターは倒れ、そのモンスターをモンスターグループから削除

			if (select_monster.getHp() <= 0) {
				monsters.remove(select_monster);
				
			}

			// モンスターグループに誰もいなくなれば、人間グループの勝利
			if (monsters.size() == 0) {
				System.out.println("人間の勝利！");
			}
			
			if (monsters.size() == 0) {
				break;
			}
			

			System.out.println("\n[モンスターのターン！]\n");

			// 人間グループから1人選択
			Human select_human2 = humans.get(Dice.get(0, humans.size() - 1));

			// モンスターグループから1人選択
			Monster select_monster2 = monsters.get(Dice.get(0, monsters.size() - 1));
			// 選ばれたモンスターが、選ばれた人間を攻撃
			select_monster2.attack(select_human2);

			// 人間のHPが0以下になれば、人間は倒れ、その人間をモンスターグループから削除
			if (select_human2.getHp() <= 0) {
				humans.remove(select_human2);
				
			}

			// 人間グループに誰もいなくなれば、人間グループの敗北
			if (humans.size() == 0) {
				System.out.println("人間の敗北！");
			}
			// 現在の各グループの状態を一覧表示
			showGroupInfos(humans, monsters);

			// ループ変数を1増やす
			count++;

			if (humans.size() == 0){
				break;
			}

		}

		// 最後に各グループの状態を一覧表示してプログラム終了
		showGroupInfos(humans, monsters);

	}

	// 引数でもらった人間グループリストからランダムに1人を選択し、その結果を戻り値とするメソッド
	public static Human choiceHuman(List<Human> humans) {
		Human human = humans.get(Dice.get(0, humans.size() - 1));
		System.out.printf("人間グループから 「%s」 のお出ましだ！\n", human.getName());
		return human;
	}

	// 引数でもらったモンスターグループリストからランダムに1人を選択し、その結果を戻り値とするメソッド
	public static Monster choiceMonster(List<Monster> monsters) {
		Monster monster = monsters.get(Dice.get(0, monsters.size() - 1));
		System.out.printf("モンスターグループから 「%s」 のお出ましだ！\n", monster.getName());
		return monster;
	}

	// 引数でもらった人間グループリストとモンスターグループリストのそれぞれの情報一覧を表示するメソッド
	public static void showGroupInfos(List<Human> humans, List<Monster> monsters) {

		System.out.println("\n## === グループ情報 === ##");
		System.out.printf("# [人間グループ]: %d人\n", humans.size());
		for (Human human : humans) {
			System.out.println(human);
		}

		System.out.printf("\n# [モンスターグループ]: %d人\n", monsters.size());
		for (Monster monster : monsters) {
			System.out.println(monster);
		}
	}

}