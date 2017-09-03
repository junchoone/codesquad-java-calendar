package honux.calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	
	public void printMenu() {
		System.out.println("+------------------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도 움 말");
		System.out.println("| q. 종 료");
		System.out.println("+------------------------------+");
	}
	// private final static String PROMPT = "cal>";

	public void runPrompt() throws ParseException {
		
		
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		PlanItem pli = new PlanItem();
		String cmd = "0";
		
		printMenu();
		while (true) {
			System.out.print("command> ");
				
			cmd = scanner.next();
			
			if(cmd.equals("1")) {
				cmdRegister(scanner, pli);
				
			} else if(cmd.equals("2")) {
				cmdSearch(scanner, pli);
				
			} else if(cmd.equals("3")) {
				cmdCal(scanner, cal);

			} else if(cmd.equals("h")) {
				printMenu();			
			} else if(cmd.equals("q")) {
				break;
//			} else if(cmd.equals("\r")) {
//				continue;
			} else {
				continue;				
			}
			
		}
		

		scanner.close();
		System.out.println("Good Bye~~");
	}

	private void cmdCal(Scanner scanner, Calendar cal) {
		// TODO Auto-generated method stub
		int year = 1;
		int month = 1;
		
		while(year > 0) {
			System.out.println("년도를 입력하세요.[메뉴 0]");
			System.out.print("YEAR > ");
			year = scanner.nextInt();
			if(year == 0) {
				return;					
			} else if (year < 1970) {
				System.out.println("1970년 이후 달력만 출력 가능합니다.");
				continue;
			} else {
				break;
			}
		}
		while(month > 0 || year !=0) {
			System.out.println("월을 입력하세요. [메뉴 0]");
			System.out.print("MONTH > ");
			month = scanner.nextInt();

			if (month > 0 && month < 13) {
				cal.printCalendar(year, month);
				return;
//				System.out.println(month + "월은 " + cal.getMaxDaysOfMonth(year, month) + "일까지 있습니다.");
			} else if (month == 0) {
//				System.out.println("종료합니다.");
				return;
			} else {
				System.out.println(month + "월은 존재하지 않습니다.");
				continue;
			}
		}				
		
	}
	private void cmdSearch(Scanner scanner, PlanItem pli) {
		// TODO Auto-generated method stub
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해 주세요(yyyy-mm-dd)");
		String date = scanner.next();
		String plan = "";
	
		try {
			plan = pli.searchPlan(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("일정검색중 오류발생");
		}
		System.out.println(plan);
		
	}
	private void cmdRegister(Scanner scanner, PlanItem pli) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 등록해 주세요(yyyy-mm-dd)");
		String date = scanner.next();
		System.out.println("일정을 등록해 주세요");
//		String text="";
//		String word="";
//		while(true) {
//			word = scanner.next();
//			text += word + " ";
//			if(word.endsWith(";")) break;
//		}
		
		String text = scanner.nextLine();
		text = scanner.nextLine();
		pli.registerPlan(date, text);
		
	}
	public static void main(String[] args) throws ParseException {
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
