package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1984_중간평균값구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			int[] arr = new int[10];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int sum = 0;

			for (int i = 0; i < 10; i++) {
				sum += arr[i];
				if (arr[i] < min) {
					min = arr[i];
				}
				if (arr[i] > max) {
					max = arr[i];
				}
			}

			double result = (sum - min - max) / 8.0;
			System.out.printf("#%d %.0f\n", tc, result);

		}

	}

}
