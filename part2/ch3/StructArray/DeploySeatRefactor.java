package part2.ch3.StructArray;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

//이 소스는 반드시 Consolas 12 폰트로 실행해 주세요.

public class DeploySeatRefactor {

	public static void main(String[] args) throws IOException {
		Deploy deploy = new Deploy();
		
		//전체 인원수 상수화
		deploy.SIZE = 26;

		//자리배정 배열 (전체자리수 26)
		deploy.seat = new String [deploy.SIZE];
		deploy.num = new int [deploy.SIZE/2];
		
		//이름 및 점수 배열
		deploy.stuNo = new int[deploy.SIZE]; //학생번호
		deploy.name = new String[deploy.SIZE]; //학생이름
		deploy.score = new int[deploy.SIZE]; //점수
		deploy.rank = new int[deploy.SIZE]; //순위
		
		//페어 배열
		deploy.pair = new String[deploy.SIZE/2][2];
		
		
		EXIT: 
		while (true) { 
			
			int menu = inputMenu();

			
			switch (menu) {			
			case 1: //>>>>>>>학생별 성적 입력
			
			inputExam(deploy);
				
			break;
			
			case 2: //>>>>>>>이름&성적 출력하기
			
			printExam(deploy);
			
			break;
			
			case 3: //>>>>>>>성적 저장하기
			saveExam(deploy);
			break;
			
			case 4: //성적파일 읽어오기
				readExam(deploy);
			break;
				
			case 5: //페어, 조, 자리배치 출력
				printSeat(deploy);
			break;
			
			case 6: //>>>>>>>이름&성적 수정하기
				changeNameScore(deploy);
			break;
			
			case 7: //>>>>>>>프로그램 종료
			{
				System.out.println(">>>프로그램이 종료되었습니다.");
			}
			break EXIT;
			
			default: //>>>>>>>메뉴입력 오류
			{
				System.out.println(">>>메뉴를 다시 입력해 주세요.");
			}
			break;
			
			}
			
		}
		
	}

	static void changeNameScore(Deploy deploy) {
		// TODO Auto-generated method stub
		//수정 불가능 메세지 (성적 입력 또는 파일을 읽어와야 합니다.)
		
		if (deploy.name[0] == null)
			System.out.println("\t☆★☆★☆★☆★☆입력된 내용이 없어 수정이 불가능합니다.☆★☆★☆★☆★☆\n");
		else {
			int go;
			do {
				//-----현재 입력된 내용 출력
				System.out.println("\tINDEX\t학생이름\t성적");
				for(int i=0;i<deploy.SIZE;i++) 
					System.out.printf("\t%d\t%s\t%d\n",i+1,deploy.name[i],deploy.score[i]);	
				
				//-----이름이나 점수 수정
				Scanner scan = new Scanner(System.in);
				
				System.out.println("수정할 INDEX를 입력해주세요");
				System.out.print("입력 > ");
				int index = scan.nextInt();
				
				System.out.print("학생이름 > ");
				String student = scan.next();
				deploy.name[index-1] = student;
				
				System.out.print("점수 > ");
				int grade = scan.nextInt();
				deploy.score[index-1] = grade;
				
				System.out.println("추가로 수정하시겠습니까?");
				System.out.println("1. 네\n2. 아니요");
				go = scan.nextInt();
				
				//이름&성적 내림차순으로 정렬
				for (int j = 0; j < deploy.SIZE - 1; j++)
					for (int i = 0; i < deploy.SIZE - 1 - j; i++) {
						if (deploy.score[i] < deploy.score[i + 1]) {
							int temp = deploy.score[i + 1];
							deploy.score[i + 1] = deploy.score[i];
							deploy.score[i] = temp;

							String tempN = deploy.name[i + 1];
							deploy.name[i + 1] = deploy.name[i];
							deploy.name[i] = tempN;
						}
					}
				
				if(go == 2)
					break;
		
			}while(go == 1);
		}
	}

	static void printSeat(Deploy deploy) throws IOException {
		// TODO Auto-generated method stub

		//공석 변수
		String vacant = "빈자리";
		//선생님들 변수
		String teac1 = "박용우", teac2 = "정용우", teac3 = "전영현";
		
		Random rnd = new Random();
		
		//출력 불가능 메세지 (성적 입력 또는 파일을 읽어와야 합니다.)
		if (deploy.score[0] == 0)
			System.out.println("\t☆★☆★☆★☆★☆입력된 성적이 없습니다.☆★☆★☆★☆★☆\n");
		
		else {
			//페어 조 랜덤
			for (int i=0; i< deploy.SIZE/2; i++) {
				deploy.num[i] = rnd.nextInt(deploy.SIZE/2);
				for (int j=0; j<i; j++) {
					if (deploy.num[i]==deploy.num[j])
						i--;
				}
			}
			
			//페어 조 짜기
			for (int i=0; i<deploy.SIZE/2; i++) {
				deploy.pair[deploy.num[i]][0] = deploy.name[i];
				deploy.pair[deploy.num[i]][1] = deploy.name[(deploy.SIZE-1)-i];
			}
			System.out.println();
			//페어 조 결과
			System.out.print("┌─────────────────────────────┐\n");
			System.out.print("            페어 결과            \n");
			System.out.print("└─────────────────────────────┘\n");
			for (int i=0; i<deploy.SIZE/2; i++)
				System.out.printf("페어 %d: %s, %s\n",i+1,deploy.pair[i][0],deploy.pair[i][1]);
			
			//자리 배정
			for (int i=0; i<deploy.SIZE/2; i++) {
				deploy.seat[2*i] = deploy.pair[i][0];
				deploy.seat[2*i+1] = deploy.pair[i][1];
			}
			System.out.println();
			
			//조 편성결과
			System.out.print("┌─────────────────────────────┐\n");
			System.out.print("           조 편성 결과          \n");
			System.out.print("└─────────────────────────────┘\n");
			System.out.println("(자리 표는 아래 \"4강의실 자리표\" 참고)");
			System.out.printf("1조: %s,%s,%s,%s,%s,%s\n",deploy.seat[0],deploy.seat[1],deploy.seat[2],deploy.seat[3],deploy.seat[4],deploy.seat[5]);
			System.out.printf("2조: %s,%s,%s,%s\n",deploy.seat[6],deploy.seat[7],deploy.seat[8],deploy.seat[9]);
			System.out.printf("3조: %s,%s,%s,%s\n",deploy.seat[10],deploy.seat[11],deploy.seat[12],deploy.seat[13]);
			System.out.printf("4조: %s,%s,%s,%s,%s,%s\n",deploy.seat[14],deploy.seat[15],deploy.seat[16],deploy.seat[17],deploy.seat[18],deploy.seat[19]);
			System.out.printf("5조: %s,%s,%s,%s,%s,%s\n",deploy.seat[20],deploy.seat[21],deploy.seat[22],deploy.seat[23],deploy.seat[24],deploy.seat[25]);
			System.out.println();
			
			//조 편성결과 저장
			FileOutputStream fos = new FileOutputStream("res/deploySeat.csv");
			PrintStream fout = new PrintStream(fos);
			
			fout.printf("1조: %s,%s,%s,%s,%s,%s\n",deploy.seat[0],deploy.seat[1],deploy.seat[2],deploy.seat[3],deploy.seat[4],deploy.seat[5]);
			fout.printf("2조: %s,%s,%s,%s\n",deploy.seat[6],deploy.seat[7],deploy.seat[8],deploy.seat[9]);
			fout.printf("3조: %s,%s,%s,%s\n",deploy.seat[10],deploy.seat[11],deploy.seat[12],deploy.seat[13]);
			fout.printf("4조: %s,%s,%s,%s,%s,%s\n",deploy.seat[14],deploy.seat[15],deploy.seat[16],deploy.seat[17],deploy.seat[18],deploy.seat[19]);
			fout.printf("5조: %s,%s,%s,%s,%s,%s\n",deploy.seat[20],deploy.seat[21],deploy.seat[22],deploy.seat[23],deploy.seat[24],deploy.seat[25]);

			fout.close();
			fos.close();
			System.out.println(">>>>조 편성 결과, 파일 저장 완료>>>>");
			
			System.out.println();
			
			//HAPPY
			System.out.println  ("==================================================================================================");
			System.out.println  ("==================================================================================================");
			System.out.println  ("= O    O   OO    OOOO   OOOO  O   O       O    O OOOOO O       O  O      OOOOOO  OOOO OOOOOOO    =");
			System.out.println  ("= O    O  O  O  O    O O    O O   O       OO   O O      O  O   O  O      O      O        O       =");	
			System.out.println  ("= OOOOOO O    O O    O O    O O   O       O O  O O      O  O  O   O      O      O        O       =");	
			System.out.println  ("= O    O OOOOOO OOOOO  OOOOO   OOO        O  O O OOOOO   O O O    O      OOOOOO O        O       =");
			System.out.println  ("= O    O O    O O      O        O         O   OO O        O O     O      O      O        O       =");
			System.out.println  ("= O    O O    O O      O        O         O    O OOOOOO   O O     OOOOOO OOOOOO  OOOOO   O       =");
			System.out.println  ("==================================================================================================");
			System.out.println  ("==================================================================================================");
			System.out.println();
			//자리배치표
			System.out.print    ("\t\t=====================================================================\n");
			System.out.print    ("\t\t                            4강의실 자리표                               \n");
			System.out.print    ("\t\t=====================================================================\n");
			System.out.println();
			System.out.print    ("\t\t┌───────┐ ┌─────────────────────────────────────────────────────────┐\n");
			System.out.print    ("\t\t│  Door │ │                       Whiteboard                        │\n");
			System.out.print    ("\t\t└───────┘ └─────────────────────────────────────────────────────────┘\n");
			//선생님 자리
			System.out.print    ("\t\t                                                           ┌────────┐\n");
			System.out.printf   ("\t\t                                                           │  %s  │ \n",teac1);
			System.out.print    ("\t\t                                                           └────────┘\n");
			//자리
			System.out.println  ("\t\t┌──────────────Group1─────────────┬─────────────Group4──────────────┐ ");
			System.out.println  ("\t\t│┌────────┐ ┌────────┐ ┌────────┐ │ ┌────────┐ ┌────────┐ ┌────────┐│");
			System.out.printf   ("\t\t││  %s │ │  %s  │ │  %s  │ │ │  %s  │ │  %s  │ │  %s  ││\n",deploy.seat[0],deploy.seat[1],deploy.seat[2],deploy.seat[14],deploy.seat[16],deploy.seat[17]);
			System.out.println  ("\t\t│└────────┘ └────────┘ └────────┘ │ └────────┘ └────────┘ └────────┘│");
			System.out.println  ("\t\t│                                 │                                 │");
			System.out.println  ("\t\t│┌────────┐ ┌────────┐ ┌────────┐ │ ┌────────┐ ┌────────┐ ┌────────┐│");
			System.out.printf   ("\t\t││  %s │ │  %s  │ │  %s  │ │ │  %s  │ │  %s  │ │  %s  ││\n",deploy.seat[4],deploy.seat[5],deploy.seat[3],deploy.seat[15],deploy.seat[18],deploy.seat[19]);
			System.out.println  ("\t\t│└────────┘ └────────┘ └────────┘ │ └────────┘ └────────┘ └────────┘│");
			System.out.println  ("\t\t├──────────────Group2─────────────┼─────────────Group5──────────────┤");
			System.out.println  ("\t\t│┌────────┐ ┌────────┐ ┌────────┐ │ ┌────────┐ ┌────────┐ ┌────────┐│");
			System.out.printf   ("\t\t││  %s │ │  %s  │ │  %s  │ │ │  %s  │ │  %s  │ │  %s  ││\n",deploy.seat[6],deploy.seat[7],deploy.seat[8],deploy.seat[20],deploy.seat[22],deploy.seat[23]);
			System.out.println  ("\t\t│└────────┘ └────────┘ └────────┘ │ └────────┘ └────────┘ └────────┘│");
			System.out.println  ("\t\t├──────────────Group3─┐           │                                 │");
			System.out.println  ("\t\t│┌────────┐ ┌────────┐│┌────────┐ │ ┌────────┐ ┌────────┐ ┌────────┐│");
			System.out.printf   ("\t\t││  %s │ │  %s  │││  %s  │ │ │  %s  │ │  %s  │ │  %s  ││\n",deploy.seat[10],deploy.seat[11],deploy.seat[9],deploy.seat[21],deploy.seat[24],deploy.seat[25]);
			System.out.println  ("\t\t│└────────┘ └────────┘│└────────┘ │ └────────┘ └────────┘ └────────┘│");
			System.out.println  ("\t\t├──────────┐          └───────────┼─────────────Mentor──────────────┤");
			System.out.println  ("\t\t│┌────────┐│┌────────┐ ┌────────┐ │ ┌────────┐ ┌────────┐ ┌────────┐│");
			System.out.printf   ("\t\t││  %s │││  %s  │ │  %s  │ │ │  %s  │ │  %s  │ │  %s  ││\n",vacant,deploy.seat[12],deploy.seat[13],teac2,teac3,vacant);
			System.out.println  ("\t\t│└────────┘│└────────┘ └────────┘ │ └────────┘ └────────┘ └────────┘│");
			System.out.println  ("\t\t└──────────┴──────────────────────┴─────────────────────────────────┘ ");   
			System.out.println(">>>>>자리배치표 출력완료>>>>>");
			System.out.println();
		}

	}

	static void readExam(Deploy deploy) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("res/scoreList.csv");
		Scanner fscan = new Scanner(fis);
		
		fscan.nextLine();
		for (int i = 0; i < deploy.SIZE; i++) {
			String[] tokens = fscan.nextLine().split(",");
			deploy.rank[i] = Integer.parseInt(tokens[0]);
			deploy.name[i] = tokens[1];
			deploy.score[i] = Integer.parseInt(tokens[2]);
		}
		
		fscan.close();
		fis.close();
		System.out.println(">>>>파일 읽기 완료>>>>");
		
	}

	static void saveExam(Deploy deploy) throws IOException {
		// TODO Auto-generated method stub
		//파일저장 불가능 메세지 (성적 입력 필수)
		if (deploy.name[0] == null)
			System.out.println("\t☆★☆★☆★☆★☆입력된 내용이 없어 파일저장이 불가능합니다.☆★☆★☆★☆★☆\n");
		else {
			FileOutputStream fos = new FileOutputStream("res/scoreList.csv");
			PrintStream fout = new PrintStream(fos);
			
			//저장 (등수/이름/성적 순)
			fout.println("등수,이름,성적");
			for (int i = 0; i < deploy.SIZE; i++) {
				deploy.rank[i] = i+1;
				fout.printf("%d,%s,%d\n", deploy.rank[i], deploy.name[i], deploy.score[i]);
			}
			
			fout.close();
			fos.close();
			System.out.println(">>>>파일 저장 완료>>>>");
		}
	}

	static void printExam(Deploy deploy) {
		// TODO Auto-generated method stub
		// 출력 불가능 메세지 (성적 입력 또는 파일을 읽어와야 합니다.)
		if (deploy.name[0] == null)
			System.out.println("\t☆★☆★☆★☆★☆학생명단 파일을 먼저 읽어주세요.☆★☆★☆★☆★☆\n");
		
		else {
			System.out.println("성적순 출력");
			for (int i=0; i<26; i++)
				System.out.printf("%d. %s %d\n",i+1,deploy.name[i],deploy.score[i]);
			System.out.println("성적출력 완료");
		}
	}

	static void inputExam(Deploy deploy) throws FileNotFoundException 
		{
			// ======== 파일에 있는 명단 불러오기
			FileInputStream fin = new FileInputStream("res/studentList.csv");
			Scanner fscan = new Scanner(fin);
			
			fscan.nextLine();
			for (int i = 0; i < deploy.SIZE; i++) {
				String[] tokens = fscan.nextLine().split(",");
				deploy.stuNo[i] = Integer.parseInt(tokens[0]);
				deploy.name[i] = tokens[1];
			}
			// ======== 불러온 명단 출력
			System.out.println("*********학생 명단*********");
			for (int i = 0; i < deploy.SIZE; i++)
				System.out.printf("%d. %s\n",deploy.stuNo[i],deploy.name[i]);
			
			System.out.println();
			System.out.println("성적 입력하기");
			
			// =========학생당 성적 입력받기
			
			Scanner scan = new Scanner(System.in);
			for (int i = 0; i < deploy.SIZE; i++) {
				do {
					System.out.printf("%d. %s: ",deploy.stuNo[i],deploy.name[i]);
					deploy.score[i] = scan.nextInt();
					if (deploy.score[i] < 0 || deploy.score[i] > 100)
						System.out.println("성적범위(0~100)을 벗어났습니다. 다시 입력해주세요.");
				}while (deploy.score[i] < 0 || deploy.score[i] > 100);
			}

			System.out.println("성적 입력이 완료되었습니다.");

			// ===========성적 내림차순으로 정렬 (등수 정렬) name[i], score[i]에서 i+1이 등수.
			for (int j = 0; j < deploy.SIZE - 1; j++)
				for (int i = 0; i < deploy.SIZE - 1 - j; i++) {
					if (deploy.score[i] < deploy.score[i + 1]) {
						int temp = deploy.score[i + 1];
						deploy.score[i + 1] = deploy.score[i];
						deploy.score[i] = temp;

						String tempN = deploy.name[i + 1];
						deploy.name[i + 1] = deploy.name[i];
						deploy.name[i] = tempN;

					}
				}
		}
		

	static int inputMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("┌──────────────────────────┐\n");
		System.out.print("│            MENU          │\n");
		System.out.print("└──────────────────────────┘\n");
		System.out.println("1. 학생별 성적 입력하기");
		System.out.println("2. 이름&성적 출력하기");
		System.out.println("3. 파일 저장하기");
		System.out.println("4. 파일 읽어오기");
		System.out.println("5. 페어&조편성 결과보기 및 저장 / 자리배치 보기");
		System.out.println("6. 이름&성적 수정하기");
		System.out.println("7. 프로그램 종료");
		System.out.print("선택 > ");
		int menu = scan.nextInt();
		return menu;
	}

}
