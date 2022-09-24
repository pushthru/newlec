package part3.ch5;

public class ExamPage {
	
	//ExamPage를 구성하는 요소로 자리하는 캡슐. Has A 한 캡슐. 
	private Exam exam = new Exam(); 
	
	
	public ExamPage(Exam exam1) {
		this.exam = exam1;
	}

	public void input() {
		
	}
	
	public void print() {
		System.out.println(exam.getKor());
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	
}
