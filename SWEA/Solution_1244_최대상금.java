package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1244_최대상금 {

	static void swap(int x, int y) {
		int tmp = x;
		x = y;
		y = tmp;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/최대상금.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String num = st.nextToken(); // 숫자판 문자열
			int N = num.length(); // 숫자판 개수
			int exchange = Integer.parseInt(st.nextToken()); // 교환 횟수
			int[] nums = new int[N]; // 숫자판 배열

			for (int i = 0; i < N; i++) { // 숫자판 배열에 입력
				nums[i] = Integer.parseInt(num.substring(i, i + 1));
			}


		} // testcase
	} // main
}
