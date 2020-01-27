package jungol;

import java.util.Scanner;

/**
 * 1303 : 숫자사각형1
 * 
 * 사각형의 높이 n과 너비 m을 입력받은 후 
 * n행 m열의 사각형 형태로 1부터 n*m번까지 숫자가 차례대로 출력되는 프로그램을 작성하시오.
 * 
 * < 처리조건 >
 * 숫자의 진행 순서는 처음에 맨 윗줄의 왼쪽에서 오른쪽으로 1부터 차례대로 너비 m만큼 출력한 후 
 * 다음 줄로 바꾸어서 다시 왼쪽에서 오른쪽으로 1씩 증가하면서 출력하는 방법으로 n번 줄까지 반복한다.
 * 
 * < 입력형식 >
 * 사각형의 높이n와 너비m( n과 m의 범위는 100 이하의 정수)이 주어진다.
 *
 * < 출력형식 >
 * 위에서 형태의 직사각형을 입력에서 들어온 높이 n과 너비 m에 맞춰서 출력한다. 숫자 사이는 공백으로 구분한다.
 * 
 */

public class Main1303 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				System.out.print(cnt++ + " ");
			System.out.println();
		}
	}
}
