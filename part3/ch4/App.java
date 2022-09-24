package part3.ch4;

public class App {

	public static void main(String[] args) {
		
		BoardConsole console = new BoardConsole();
		
		console.print();
		console.putOmok();
		console.print();
		console.putOmok();
		console.print();
		console.rollbackOmok();
		console.print();
		console.putOmok();
		console.print();
		
	}

}
