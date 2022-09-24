package part3.ch2;

import java.util.Scanner;

public class Lotto {
	
	private int[] nums;
	
	public void init() {
		nums = new int[6];
	}
	
	public void input() {
		System.out.println("로또 번호 6개를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		for (int i=0; i<6; i++) 
			this.nums[i] = scan.nextInt();
	}
	
	public void print() {
		System.out.print("로또 번호: ");
		for (int i=0; i<6; i++) 
			System.out.printf("%d ", this.nums[i]);
		System.out.println();
	}

	public void sort() {
		for (int j=0; j<5; j++) {
			for (int i=0; i<5-j; i++) {
				if (nums[i] > nums[i+1]) {
					int temp = nums[i];
					nums[i] = nums[i+1];
					nums[i+1] = temp;
				}
			}	
		}
	}

}
