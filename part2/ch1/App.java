	package part2.ch1;
	import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.PrintStream;
	import java.util.Scanner;

	public class App {

	   public static void main(String[] args) throws IOException {
	       TODO Auto-generated method stub   
	      int kor=0;
	      int eng=0;
	      int math=0;
	      
	      
	      
	      Scanner scan = new Scanner(System.in);      
	      
	      EXIT:
	      while(true)
	      {         
	         int menu = inputMenu(scan);
	         
	         switch(menu){
	         case 1:
	        	 inputExam(kor, eng, math);
	        
	            break;
	         case 2:
	         {
	             
	             int total = kor+eng+math;
	             float avg = total/3.0f;               
	             
	             System.out.print("┌─────────────────────────────┐\n");
	             System.out.print("│            성적 출력           │\n");
	             System.out.print("└─────────────────────────────┘\n");
	                            
	             System.out.printf("kor : %d\n", kor);
	             System.out.printf("eng : %d\n", eng);
	             System.out.printf("math : %d\n", math);
	             System.out.printf("total : %d\n", total);
	             System.out.printf("avg : %f\n", avg);                  
	             
	          }
	  	   	            
	            break;
	         case 3:
	         {
	             FileOutputStream fos = new FileOutputStream("res/data.csv");
	             PrintStream fout = new PrintStream(fos);
	             
	             fout.println("kor,eng,math");
	             fout.printf("%d,%d,%d\n",kor,eng,math);
	             
	             fout.close();
	             fos.close();
	          }   
	  	 
	        	 
	            break;
	         case 4:
	        	 saveExam(kor, eng, math);
	                   
	           
	            break;
	         case 5:
	            System.out.println("Bye~~~");
	            break EXIT;
	            
	         default:
	            System.out.println("메뉴는 1~5번만 선택할 수 있습니다.");
		            break;
		         }
		      }      
		   }
	   
	   static int inputMenu(Scanner scan)
		{
			System.out.print("┌─────────────────────────────┐\n");
	        System.out.print("│            메인 메뉴           │\n");
	        System.out.print("└─────────────────────────────┘\n");
	        System.out.println("1. 성적입력");
	        System.out.println("2. 성적출력");
	        System.out.println("3. 성적저장");
	        System.out.println("4. 성적읽기");
	        System.out.println("5. 종료");
	        System.out.print(">");
	        int menu = scan.nextInt();
			return menu;
		}
	   
	   static void saveExam(int kor, int eng, int math) throws IOException
	   {
           FileInputStream fis = new FileInputStream("res/data.csv");
           Scanner fscan = new Scanner(fis);
           
           String titles = fscan.nextLine(); // 필드명 행 건너뛰기
           String[] nums = fscan.nextLine().split(",");
           kor = Integer.parseInt(nums[0]);
           eng = Integer.parseInt(nums[1]);
           math = Integer.parseInt(nums[2]);
           
           fscan.close();
           fis.close();
           
        }
	   
	   static void inputExam(int kor, int eng, int math)
	   {
		   Scanner scan = new Scanner(System.in);
		   
           System.out.print("┌─────────────────────────────┐\n");
           System.out.print("│            메인 입력           │\n");
           System.out.print("└─────────────────────────────┘\n");
           
           String[] titles = {"kor", "eng", "math"};
           int[] nums = new int[3];
           
           for(int i=0;i<3; i++) {
              int temp;
              do {
                 System.out.printf("%s:", titles[i]);
                 temp = scan.nextInt();
                 
                 if(temp<0 ||temp>100)
                    System.out.println("성적은 (0~100) 범위를 벗어날 수 없습니다.");
                 
              }while(temp<0 || temp>100);   
           
              nums[i] = temp;
           }
           
           kor = nums[0];
           eng = nums[1];
           math = nums[2];
        
        }	        	

	}
		


	
		
	
