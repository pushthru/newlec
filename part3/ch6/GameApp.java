package part3.ch6;

import java.awt.Frame;

public class GameApp {

	public static void main(String[] args) {

		YBMExam exam = new YBMExam();
		
		System.out.println(exam.getKor());
		System.out.println(exam.getCom());
		
		GameFrame win = new GameFrame();
		win.setSize(400, 400);
		win.setVisible(true);
		
	}

}
