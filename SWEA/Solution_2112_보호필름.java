import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2112_보호필름 {
	static int R, C, K, result;
	static int[][] map, film;
	static int[] pick;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			film = new int[R][C];
			pick = new int[R];
			result = K;

			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dfs(0, 0);
			System.out.println("#" + tc + " " + result);
		}
	}

	private static void dfs(int cur, int cnt) {
		if (cnt > result) return;

		if (cur == R) {
			film = copyMap(map);
			for (int i = 0; i < R; i++) {
				if (pick[i] == -1) continue;
				Arrays.fill(film[i], pick[i]);
			}
			if (test())
				result = Math.min(result, cnt);
			return;
		}

		pick[cur] = -1; dfs(cur + 1, cnt);		// 선택 x
		pick[cur] = 0; 	dfs(cur + 1, cnt + 1);	// A 주입
		pick[cur] = 1; 	dfs(cur + 1, cnt + 1);	// B 주입
	}

	private static boolean test() {
		for (int j = 0; j < C; j++) {
			int cnt = 1;
			boolean flag = false;

			for (int i = 1; i < R; i++) {
				if (film[i][j] == film[i - 1][j]) cnt++;
				else cnt = 1;
				if (cnt == K) {
					flag = true;
					break;
				}
			}
			if (!flag) return false;
		}
		return true;
	}

	private static int[][] copyMap(int[][] arr) {
		int[][] result = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				result[i][j] = arr[i][j];
			}
		}
		return result;
	}
}
