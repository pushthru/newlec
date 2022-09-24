package part3.ch2;

import java.util.Scanner;

public class Exam {
	
	private int kor, eng, math;
	int total;
	float avg;
	
	public void input() {
		
		System.out.println("====================");
		System.out.println("      성적 입력");
		System.out.println("====================");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("국어: ");
		this.kor = scan.nextInt();
		System.out.print("영어: ");
		this.eng = scan.nextInt();
		System.out.print("수학: ");
		this.math= scan.nextInt();
	}

	public void print() {

		System.out.println("====================");
		System.out.println("      성적 출력");
		System.out.println("====================");

		
		total = this.kor+this.eng+this.math;
		avg = this.total/3.0f;
		
		System.out.printf("국어 : %d\n", this.kor);
		System.out.printf("영어 : %d\n", this.eng);
		System.out.printf("수학 : %d\n", this.math);
		System.out.printf("총합 : %d\n", this.total);
		System.out.printf("평균 : %.2f\n", this.avg);
		
		
	}

}
