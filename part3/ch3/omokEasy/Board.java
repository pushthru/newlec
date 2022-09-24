package part3.ch3.omokEasy;

public class Board {

	private char[][] buf;
	final int WIDTH;
	final int HEIGHT;

	public Board() {
		WIDTH = 20;
		HEIGHT = 20;
		buf = new char[HEIGHT][WIDTH];

		// '┼' 문자 채우기
		for (int y = 1; y <= HEIGHT; y++)
			for (int x = 1; x <= WIDTH; x++)
				buf[y - 1][x - 1] = '┼';
		// 위, 아래
		for (int x = 1; x <= WIDTH; x++) {
			buf[0][x - 1] = '┬';
			buf[HEIGHT - 1][x - 1] = '┴';
		}

		// 좌, 우
		for (int y = 1; y <= HEIGHT; y++) {
			buf[y - 1][0] = '├';
			buf[y - 1][WIDTH - 1] = '┤';
		}

		// 꼭지점
		buf[0][0] = '┌';
		buf[0][WIDTH - 1] = '┐';
		buf[HEIGHT - 1][0] = '└';
		buf[HEIGHT - 1][WIDTH - 1] = '┘';

	}

	public void print() {
		// 오목판 출력
		for (int y = 1; y <= HEIGHT; y++) {
			for (int x = 1; x <= WIDTH; x++)
				System.out.printf("%c", buf[y - 1][x - 1]);
			System.out.println();
		}
	}

	public void put(Omok omok) {
		if (omok.getColor()%2==1)
			buf[omok.getY()-1][omok.getX()-1] = '○';
		else
			buf[omok.getY()-1][omok.getX()-1] = '●';
			
	}

	public char getbuf(int x, int y){
		return buf[y-1][x-1];
	}
}
