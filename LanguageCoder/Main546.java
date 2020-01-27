package jungol;

import java.util.Scanner;
import java.math.*;

/**
 * 
 * 10 이하의 과목수 n을 입력받은 후 n개 과목의 점수를 입력받아서 평균을 구하여 출력하고 평균이 80점이상이면 "pass", 80점
 * 미만이면 "fail"이라고 출력하는 프로그램을 작성하시오. 평균은 반올림하여 소수 첫째자리까지 출력한다
 */
public class Main546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int score;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			score = sc.nextInt();
			sum += score;
		}
		double avg = Math.round(((double) sum / n) * 10) / 10d;
		System.out.println("avg : " + avg);

		if (avg >= 80)
			System.out.println("pass");
		else
			System.out.println("fail");

	}
}
