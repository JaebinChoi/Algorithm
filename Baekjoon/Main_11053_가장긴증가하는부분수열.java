package staging;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11053_가장긴증가하는부분수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];
		int[] LIS = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++)
			num[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			LIS[i] = 1;
			for (int j = 1; j < i; j++) {
				// i보다 작은 숫자를 찾고, 작은 숫자의 LIS + 1과 i의 LIS 비교
				if (num[i] > num[j] && LIS[j] + 1 > LIS[i]) {
					LIS[i] = LIS[j] + 1;
				}
			}
		}

		// 가장 긴 LIS 찾기
		int index = 0;
		for (int i = 1; i <= N; i++) {
			if (LIS[index] < LIS[i]) {
				index = i;
			}
		}
		System.out.println(LIS[index]);
	}
}
