package part3.ch5;

public class App {

	public static void main(String[] args) {
		
		Exam exam1 = new Exam(0,0,0);
		Exam exam2 = new Exam(100,100,100);
		
		ExamPage page = new ExamPage(exam1);
		page.print();
		
		page.setExam(exam2);
		page.print();
		

	}

}
