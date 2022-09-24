package part3.ch2;

public class LottoApp {
	
	public static void main(String[] args) {
		
		Lotto lotto = new Lotto();
		

		lotto.init();
		//입력
		lotto.input();
		//출력
		lotto.print();
		//정렬
		lotto.sort();
		//출력
		lotto.print();
		
	}

}
