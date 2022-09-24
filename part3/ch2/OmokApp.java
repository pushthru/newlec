package part3.ch2;

public class OmokApp {

	public static void main(String[] args) {
		
		Board board = new Board();
		Omok omok = new Omok();
		
		board.init();
		board.print();
		omok.input();
		board.put(omok);
		board.print();

	}

}
