package part2.ch2;

import java.util.Random;
import java.util.Scanner;

public class LottoTest {
	public static void main (String[] args) {
		
		Lotto lotto = new Lotto();
		lotto.nums = new int[6];
		lotto.all = new int[45];
		
		inputLotto(lotto); 
		outputLotto(lotto); 
	}
	
	static void inputLotto(Lotto lotto)
	{
//		카드 섞는 코드... 
		Random rand = new Random();

		for (int i=0; i<45; i++) 
			lotto.all[i] = i;
		
		for (int i=0; i<45; i++) {
			int temp = lotto.all[i];
			lotto.all[i] = lotto.all[rand.nextInt(45)];
			lotto.all[rand.nextInt(45)] = temp;
		}
		
//		Scanner scan = new Scanner(System.in);
//		for (int i=0; i<6; i++) {
//			//
//			do {
//					System.out.printf("로또번호 %d: ", i+1);
//					lotto.nums[i] = scan.nextInt();
//					if (lotto.nums[i]<0 || lotto.nums[i]>46)
//						System.out.println("1~45 사이의 값을 입력해주세요.");
//			}while (lotto.nums[i]<1 || lotto.nums[i]>46);
//			
//			//중복 제거 
//			for(j=0; j<i; j++) {
//				if(lotto.nums[j] == lotto.nums[i]) {
//					i--;
//					break;
//				}
//			}
//		}
		
	}
		
	
	
	static void outputLotto(Lotto lotto)
	{
		
		
		System.out.print("랜덤 당첨 번호 : ");
		for (int i=0; i<6; i++){
			lotto.nums[i] = lotto.all[i];
			System.out.printf("%d ",lotto.nums[i]);
		}
		
//		System.out.print("당첨 번호 : ");
//		for (int i=0; i<6; i++)
//			System.out.printf("%d ",lotto.nums[i]);
	}
	
	
}
