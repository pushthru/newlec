package part3.ch3;

public class App {

	public static void main(String[] args) {
		
		ExamPage page = new ExamPage();
		Exam exam = new Exam(0,10,0);
		Exam exam1 = new Exam(40,50,70);
		Exam exam2 = new Exam();
		
		page.input();
		page.print();
		
		System.out.println(exam);
//		System.out.println(exam1.toString());
//		System.out.println(exam2.toString());

	}

}
