package jungol;

import java.util.Scanner;
import java.math.*;

/**
 * 
 * 0 부터 100 까지의 점수를 계속 입력받다가 범위를 벗어나는 수가 입력되면 그 이전까지 입력된 자료의 합계와 평균을 출력하는 프로그램을
 * 작성하시오. (평균은 반올림하여 소수 첫째자리까지 출력한다.)
 *
 */
public class Main127 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int sum = 0;
		int count = 0;

		while (true) {
			int num = sc.nextInt();

			if (num > 100 || num < 0)
				break;

			sum += num;
			count++;
		}
		if (count > 0) {
			double avg = Math.round(((double) sum / count) * 10) / 10d;
			System.out.println("sum : " + sum);
			System.out.println("avg : " + avg);
		}
	}
}
