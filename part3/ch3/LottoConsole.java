package part3.ch3;

import java.util.Scanner;

public class LottoConsole {

	private Lotto lotto;
	
	public LottoConsole() {
		lotto = new Lotto();
	}
	
	public void input() {
		System.out.println("─────────────────────");
		System.out.println("      로또 입력");
		System.out.println("─────────────────────");
		System.out.println("로또 번호 6개를 입력하세요.");
		
		Scanner scan = new Scanner(System.in);
		for (int n = 1; n <= 6; n++) {
			int num = scan.nextInt();
			lotto.set(n, num);
		}
	}

	public void print() {
		System.out.println("─────────────────────");
		System.out.println("      로또 출력");
		System.out.println("─────────────────────");
		System.out.print("로또 번호를 출력합니다.");
		lotto.sort();
		for (int n = 1; n <= 6; n++)
			System.out.printf("%d ", lotto.get(n));
		System.out.println();
		System.out.println("로또 번호 출력을 완료하였습니다.");
	}

}
