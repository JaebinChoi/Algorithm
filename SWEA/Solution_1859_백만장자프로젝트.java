package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1859_백만장자프로젝트 {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/백만장자프로젝트.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			long result = 0;
			int cnt = 0;
			long sell = 0;
			long sum = 0;

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			for (int i = N - 1; i >= 0; i--) {
				if (sell == 0) {
					sell = arr[i];
					continue;
				}

				if (sell < arr[i]) {
					result += (cnt * sell) - sum;
					sell = arr[i];
					cnt = 0;
					sum = 0;
				} else {
					cnt++;
					sum += arr[i];
				}

				if (i == 0) {
					result += (cnt * sell) - sum;
				}
			}
			System.out.println("#" + tc + " " + result);
		}

	}
}
