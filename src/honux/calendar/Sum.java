package honux.calendar;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		System.out.println("두 수의 합을 출력합니다. 두 수를 입력하세요");
		Scanner sc = new Scanner(System.in);
		String s1,s2;
		s1 = sc.next();
		s2 = sc.next();
		System.out.println("입력하신 값은 " + s1 + ", " + s2 + " 입니다.");
		
		int a,b; 
		a = Integer.parseInt(s1);
		b = Integer.parseInt(s2);
		
//		int first = sc.nextInt();
//		int second = sc.nextInt();
		System.out.println("두 수의 합은 " + (a + b) + " 입니다.");
		sc.close();
	}
}
