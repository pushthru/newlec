package part3.ch4;

public class Board {
	private char[][] buf;
	private Omok[] omoks;
	private int index;
	
	public Board() {
		buf = new char[20][20];
		omoks = new Omok[400];	
		index = 0;
		init(); // 질문: 왜 여기 안에 buf배열 입력 안하고 init 따로 만드는지?
	}

	private void init() {
		for (int y=0; y<20; y++)
			for(int x=0; x<20; x++) 
				buf[y][x] = '┼';
	}

	public char get(int x, int y) {
		return buf[y][x];
	}

	public void put(Omok omok) {
//		if (omok.getColor() == 0)
//			buf[omok.getY()][omok.getX()] = '●';
//		else
//			buf[omok.getY()][omok.getX()] = '○';
		omoks[index] = omok;
		index++;
	}

	public void rollback() {
		index--;
		omoks[index] = null;
	}

	public void repaint() {
		this.init();
//		buf[omoks[index].getY()][omoks[index].getX()] = '┼';
		for (int i=0; i<index; i++) 
			if (omoks[i].getColor() == 0)
				buf[omoks[i].getY()][omoks[i].getX()] = '●';
			else
				buf[omoks[i].getY()][omoks[i].getX()] = '○';
	}
}
