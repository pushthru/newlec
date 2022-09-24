package part3.ch4;

import java.util.Scanner;

public class BoardConsole {
	private Board board;
	private int turn;
	
	public BoardConsole() {
		board = new Board();
		turn = 0;
	}

	public void print() {
		
		board.repaint(); //추가 
		
		for (int y=0; y<20; y++) {
			for(int x=0; x<20; x++) 
				System.out.printf("%c",board.get(x,y));
			System.out.println();
		}
	}

	public void putOmok() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("좌표 입력(x y)_");
		int x = scan.nextInt();
		int y = scan.nextInt();
		int color = turn;
		
		Omok omok = new Omok(x, y, color);
		// omok 새로 만들어서 입력 값으로 초기화
		
		board.put(omok);
		if (color == 0)
			turn = 1;
		else 
			turn = 0;
	}

	public void rollbackOmok() {
		board.rollback(); //
		
	}
	

	
}
