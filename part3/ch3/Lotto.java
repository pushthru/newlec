package part3.ch3;

import java.util.Scanner;

public class Lotto {

	private int[] nums;

	public Lotto() {
		nums = new int[6];
	}

	public void set(int n, int num) {
		this.nums[n - 1] = num;
	}

	public int get(int n) {
		return this.nums[n - 1];
	}

	public void sort() {
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 5 - j; i++) {
				if (nums[i] > nums[i + 1]) {
					int temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = temp;
				}
			}
		}
	}
}
