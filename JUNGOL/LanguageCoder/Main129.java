package jungol;

import java.util.Scanner;
import java.math.*;

/**
 * 
 * 삼각형의 밑변의 길이와 높이를 입력받아 넓이를 출력하고 "Continue? "에서 하나의 문자를 입력받아 그 문자가 'Y' 나 'y' 이면
 * 작업을 반복하고 다른 문자이면 종료하는 프로그램을 작성하시오. (넓이는 반올림하여 소수 첫째자리까지 출력한다.)​
 */
public class Main129 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String con;
		do {
			System.out.print("Base = ");
			int base = sc.nextInt();

			System.out.print("Height = ");
			int height = sc.nextInt();

			double width = Math.round(((double) base * height / 2) * 10) / 10d;

			System.out.println("Triangle width = " + width);

			System.out.print("Continue? ");
			con = sc.next().toUpperCase();
		} while (con.equals("Y"));

	}
}
