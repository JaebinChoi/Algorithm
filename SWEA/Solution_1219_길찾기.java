import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 완전 탐색
public class Solution_1219_길찾기 {
	static int N, result;
	static int[] arr1, arr2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			N = Integer.parseInt(st.nextToken());
			arr1 = new int[N];
			arr2 = new int[N];
			result = 0;

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				int idx = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				if (arr1[idx] == 0)
					arr1[idx] = num;
				else
					arr2[idx] = num;
			}

			sol(0);
			System.out.println("#" + tc + " " + result);
		}
	}

	private static void sol(int cur) {
		int flag1 = arr1[cur];
		int flag2 = arr2[cur];

		// 도착지에 도착
		if (flag1 == 99 || flag2 == 99) {
			result = 1;
			return;
		}

		// 경로 이동
		if (flag1 != 0) sol(flag1);
		if (flag2 != 0) sol(flag2);
	}
}