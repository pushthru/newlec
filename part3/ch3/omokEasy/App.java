package part3.ch3.omokEasy;

import java.io.ObjectInputStream.GetField;

public class App {

	public static void main(String[] args) {
		
		Board board = new Board();
		Omok omok = new Omok();
		
		board.print();
		while(true) {
			omok.input();
			board.put(omok);
			board.print();
		}

	}

}
