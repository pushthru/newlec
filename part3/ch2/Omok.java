package part3.ch2;

import java.util.Scanner;

public class Omok {
	
	private int ox, oy;
	private int color;

	public void input() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("오목을 둘 위치를 입력하세요(x y)_");
		ox = scan.nextInt();
		oy = scan.nextInt();
		
	}

}
