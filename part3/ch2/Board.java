package part3.ch2;

public class Board {
	
	private int WIDTH;
	private int HEIGHT;
	private char[][] buf;

	public void init() {
		WIDTH = 20;
		HEIGHT = 20;
		buf = new char[HEIGHT][WIDTH];
		
		for(int y=1;y<=HEIGHT;y++) 
            for(int x=1;x<=WIDTH;x++) 
               buf[y-1][x-1]= '┼';
         
	     for(int x=1; x<=WIDTH; x++) 
	        buf[0][x-1]='┬';
	                
	     for(int x=1; x<=WIDTH; x++) 
	        buf[HEIGHT-1][x-1]='┴';
	     
	     for(int y=1; y<=HEIGHT; y++) 
	        buf[y-1][0]='├';
	     
	     for(int y=1; y<=HEIGHT; y++) 
	        buf[y-1][WIDTH-1]='┤';
	     
	     buf[0][0]='┌';
	     buf[0][WIDTH-1]='┐';
	     buf[HEIGHT-1][0]='└';
	     buf[HEIGHT-1][WIDTH-1]='┘';

	}

	public void print() {
		
         for(int y=1;y<=HEIGHT;y++) {
            for(int x=1;x<=WIDTH;x++) 
               System.out.printf("%c",buf[y-1][x-1]);
            System.out.println();
        }         
	}

	public void put(Omok omok) {
		
		buf[y-1][x-1] = '○';
		
		//getter, setter
	}

}
