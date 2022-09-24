package part3.ch1;

public class App {

	public static void main(String[] args) {

		Board board = new Board();
		Omok omok = new Omok();
		
		//초기화
		board.init();
		//오목판 출력
		board.print();
		//사용자로부터 오목 입력받기
		omok.input();
		//오목판에 오목 두기
		board.put(omok);
		//오목판 출력
		board.print();
		
		int x;
		System.out.print(x);
		
		System.out.print(omok.x);
		
		
	}

}
