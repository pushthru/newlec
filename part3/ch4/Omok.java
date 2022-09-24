package part3.ch4;

public class Omok {
	private int x, y; // omok과 속성과의 관계는 Has a 아님. 캡슐간의 관계만.
	private int color;
	
	public Omok() {
	}
	
	public Omok(int x, int y, int color) {
		this.x = x;//받아온 인자를 class 멤버x, y에 각각 집어넣음
		this.y = y;
		this.color = color;
	}
	
	public int getX() {
		return x;//숨기는 의미가 있나..?
	}
	
	public int getY() {
		return y;
	}
	
	public int getColor() {
		return color;
	}
	
	
}