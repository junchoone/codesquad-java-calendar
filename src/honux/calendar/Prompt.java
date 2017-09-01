package honux.calendar;

import java.util.Scanner;

public class Prompt {

	// private final static String PROMPT = "cal>";

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int year = 1;
		int month = 1;
		int day = 1;
		while (month > 0) {
			System.out.println("년도를 입력하세요. [종료 0]");
			System.out.print("YEAR > ");
			year = scanner.nextInt();
			if (year == 0) {
				System.out.println("종료합니다.");
				break;
			}
			System.out.println("월을 입력하세요. [종료 0]");
			System.out.print("MONTH > ");
			month = scanner.nextInt();

			if (month > 0 && month < 13) {
//				cal.printCalendar(year, month);
//				System.out.println(month + "월은 " + cal.getMaxDaysOfMonth(year, month) + "일까지 있습니다.");
			} else if (month == 0) {
				System.out.println("종료합니다.");
			} else {
				System.out.println(month + "월은 존재하지 않습니다.");
			}
			System.out.println("일자를 입력하세요. [종료 0]");
			System.out.print("Day > ");
			day = scanner.nextInt();
			if (day == 0) {
				System.out.println("종료합니다.");
				break;
			}
			cal.printCalendar(year, month);
			System.out.printf("%d년 %d월 %d일은 ",year,month,day);
			System.out.println(cal.getWeekDay(year, month, day) + "입니다.");
			System.out.println();
			
		}
		scanner.close();
		System.out.println("Bye~~");
	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
