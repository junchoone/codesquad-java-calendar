package honux.calendar;

import java.util.Scanner;

public class Calendar {
	
	private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public int getMaxDayOfMonth(int month) {
		return MAX_DAYS[month -1];
	}
	public static void printSempleCalendar() {
		
		System.out.println("일  월  화  수  목  금  토");
		System.out.println("--------------------");
		System.out.println("30 31 01 02 03 04 05");
		System.out.println("06 07 08 09 10 11 12");
		System.out.println("13 14 15 16 17 18 19");
		System.out.println("20 21 22 23 24 25 26");
		System.out.println("27 28 29 30 31");
	}
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		System.out.println("달을 입력하세요");
		int month = scanner.nextInt();
		System.out.println(month + "월은 " + cal.getMaxDayOfMonth(month) + "일까지 있습니다.");
		cal.printSempleCalendar();
	}

}
