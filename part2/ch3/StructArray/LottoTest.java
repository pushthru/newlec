package part2.ch3.StructArray;

import java.util.Random;
import java.util.Scanner;

public class LottoTest {
	
	public static void main(String[] args) {

		LottoList list = new LottoList();

		list.lottos = new Lotto[3];
		list.index = 0;
		
		inputLottos(list);
		outputLottos(list);
	}

	//// input 부분 하다가 맘. 이어서 하기!! Lotto 배열 새로 만드는 부분부터.
	
	static void inputLottos(LottoList list) {

		Scanner scan = new Scanner(System.in);
		lotto.nums = new int[6];
		Lotto lotto = new Lotto();		
		
		
		for (int i = 0; i < 6; i++) {
			int temp;
			do {
				System.out.printf("로또번호 %d: ", i + 1);
				temp = scan.nextInt();
				if (temp < 0 || temp > 46)
					System.out.println("1~45 사이의 값을 입력해주세요.");
				lotto.nums[i] = temp;
			
			} while (temp < 0 || temp > 46);
			

			// 중복 제거
			for (int j = 0; j < i; j++) {
				if (lotto.nums[j] == lotto.nums[i]) {
					i--;
					break;
				}
			}
			

			lottos[i] = lotto
			list.index++;
			
		}
		
		//로또 배열에 집어넣기
		
		

	}

	static void outputLottos(LottoList list) {

		System.out.print("당첨 번호 : ");
		for (int i = 0; i < 6; i++)
			System.out.printf("%d ", lotto.nums[i]);
	}

}
