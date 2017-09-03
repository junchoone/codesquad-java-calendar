package honux.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Calendar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	
	
//	public Calendar() {
//		planMap = new HashMap<Date, String>();
//	}
//	public void registerPlan(String strDate, String plan) throws ParseException {
//		Date date = new SimpleDateFormat("yyyy-mm-dd").parse(strDate);
//		planMap.put(date, plan);
//	}
//	public String searchPlan(String strDate) throws ParseException {
//		Date date = new SimpleDateFormat("yyyy-mm-dd").parse(strDate);
//		String plan = planMap.get(date);
//		return plan;
//	}
	
	public static boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		return false;
	}

	public static int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		} else {
			return MAX_DAYS[month - 1];
		}
	}

	public static int getFirstDay(int year) {
		int firstCnt = 0;
		if (year < 2017) {
			for (int i = year; i < 2017; i++) {
				if (isLeapYear(i))
					firstCnt += 5;
				else
					firstCnt += 6;
			}
			return firstCnt;
		} else if (year > 2017) {
			for (int i = (year - 1); i > 2017; i--) {
				if (isLeapYear(i))
					firstCnt += 2;
				else
					firstCnt += 1;
			}
			return firstCnt;
		} else {
			return 0;
		}
	}

	public static String getWeekDay(int year, int month, int day) {
		int sum = 0;
		int[] max;
		if(isLeapYear(year)) {
			max = LEAP_MAX_DAYS;
		} else {
			max = MAX_DAYS;
		}
				
		for (int i = 0; i < (month - 1); i++) {
			sum += max[i];
		}
		sum += getFirstDay(year); 
		sum += (day-1);
		int weekDay = sum % 7;
		switch (weekDay) {
			case 0:
				return "일요일";
			case 1:
				return "월요일";
			case 2:
				return "화요일";
			case 3:
				return "수요일";
			case 4:
				return "목요일";
			case 5:
				return "금요일";
			case 6:
				return "토요일";
			default:
				return "요일 가져오기 실패!!";
		}						
	}

	public static void printCalendar(int year, int month) {
		int sum = 0;
		int[] max;
		if (isLeapYear(year)) {
			max = LEAP_MAX_DAYS;
		} else {
			max = MAX_DAYS;
		}

		for (int i = 0; i < (month - 1); i++) {
			sum += max[i];
		}
		sum += getFirstDay(year);
		int firstDay = sum % 7;
		System.out.println();
		System.out.println("   << " + year + "년 " + month + "월 >>");
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		int j = 1;
		int maxDays = getMaxDaysOfMonth(year, month);
		for (int i = 0; i < maxDays; i++) {
			for (int k = 0; k < firstDay; k++) {
				System.out.printf("   ");
				j++;
			}
			firstDay = 0;
			System.out.printf("%3d", (i + 1));

			if (j % 7 == 0) {
				System.out.println();
			}

			j++;
		}
		System.out.println();
		System.out.println();

		// System.out.println("30 31 01 02 03 04 05");
		// System.out.println("06 07 08 09 10 11 12");
		// System.out.println("13 14 15 16 17 18 19");
		// System.out.println("20 21 22 23 24 25 26");
		// System.out.println("27 28 29 30 31");

	}

}
