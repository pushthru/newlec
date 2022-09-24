package part3.ch3.omokEasy;

import java.util.Scanner;

public class Omok {
	
	private int x, y;
	private int index;
	private int color;
	
	public Omok() {
		index = 0;
	}
	
	public void input() {
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("오목을 둘 위치를 입력하세요(x y)_");
			x = scan.nextInt();
			y = scan.nextInt();
			index++; 
			color = index;
			if (board.getbuf(this.x, this.y) == '○' || board.getbuf(this.x, this.y) == '●')
				System.out.println("이미 돌이 있는 위치입니다. 다시 입력해주세요.");
		}while (board.getbuf(this.x, this.y) == '○' || board.getbuf(this.x, this.y) == '●');
		

		
	}
	
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public int getColor() {
		return this.color;
	}
}
