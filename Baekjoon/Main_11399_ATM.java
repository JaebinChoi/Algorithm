package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11399_ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 사람 수
		int[] time = new int[N]; // 출금 소요시간

		for (int i = 0; i < N; i++) {
			time[i] = sc.nextInt();
		}
		Arrays.sort(time);

		int sum = 0;
		for (int i = 0; i < N; i++) { // 첫째수 = N번 출현, 둘째수 = N-1번, ~ 마지막수 = N - (N - 1) = 1번
			sum = sum + (time[i] * (N - i));
		}
		System.out.println(sum);
	}
}
