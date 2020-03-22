package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_5568_카드놓기 {
	static int N, R;
	static String[] numbers;
	static String[] comb, per;
	static boolean[] visited;
	static ArrayList<String> list = new ArrayList<>();
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		R = Integer.parseInt(br.readLine());
		numbers = new String[N];
		comb = new String[R];
		per = new String[R];
		visited = new boolean[R];

		for (int i = 0; i < N; i++)
			numbers[i] = br.readLine();

		combination(0, 0);
		System.out.println(result);
	}

	/** 조합을 구하는 메소드 */
	private static void combination(int cur, int cnt) {
		if (cnt == R) { // 조합한 수로 순열
			permutation(0);
			return;
		}

		for (int i = cur; i < N; i++) {
			comb[cnt] = numbers[i];
			combination(i + 1, cnt + 1);
		}
	}

	private static void permutation(int cnt) {
		if (cnt == R) {
			String str = "";
			for (int i = 0; i < R; i++) {
				str += per[i];
			}

			if (!list.contains(str)) {
				list.add(str);
				result++;
			}
			return;
		}
		for (int i = 0; i < R; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			per[cnt] = comb[i];

			permutation(cnt + 1);

			visited[i] = false;
		}
	}
}
