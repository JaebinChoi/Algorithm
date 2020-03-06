package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3521_그리디알고리즘 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = { 1, 2, 4, 8, 16 };
		int[] cnt = new int[5];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 5; i++)
			cnt[i] = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(st.nextToken());

		int result = 0;
		for (int i = 4; i >= 0; i--) {
			if (cnt[i] == 0)
				continue;

			int mok = N / arr[i];

			if (mok > cnt[i]) {
				mok = cnt[i];
			}
			result += mok;
			N -= mok * arr[i];

			if (N == 0)
				break;
		}

		System.out.println(result);
	}
}
