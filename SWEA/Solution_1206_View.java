package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1206_View {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/View.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int testcase = 1; testcase <= 10; testcase++) {
			int N = Integer.parseInt(br.readLine()); // 빌딩수
			int[] arr = new int[N]; // 빌딩 높이 배열
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			// 빌딩 입력
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int cnt = 0;
			// 빌딩 순회
			for (int i = 2; i < N - 2; i++) {
				// (현재빌딩 - 2) ~ (현재빌딩 + 2) 까지 현재빌딩보다 높이가 낮을 경우
				if (arr[i - 2] < arr[i] && arr[i - 1] < arr[i] && arr[i + 1] < arr[i] && arr[i + 2] < arr[i]) {
					// 현재빌딩 - (현재빌딩 - 2) ~ (현재빌딩 + 2) 해서 가장 작은 값 찾기
					int min1 = Math.min(arr[i] - arr[i - 2], arr[i] - arr[i - 1]);
					int min2 = Math.min(arr[i] - arr[i + 1], arr[i] - arr[i + 2]);
					cnt += Math.min(min1, min2);
				}
			} // 빌딩 순회
			System.out.println("#" + testcase + " " + cnt);

		} // testcase
	} // main
}
