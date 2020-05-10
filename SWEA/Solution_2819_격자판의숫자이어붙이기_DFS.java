import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_2819_격자판의숫자이어붙이기_DFS {
	static final int N = 4;
	static int[][] map;
	static HashSet<String> set;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			map = new int[N][N];
			set = new HashSet<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, "" + map[i][j], 0);
				}
			}
			System.out.println("#" + tc + " " + set.size());
		}
	}

	private static void dfs(int r, int c, String str, int cnt) {
		if (cnt == 6) {
			set.add(str);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if (isIn(nr, nc))
				dfs(nr, nc, str + map[nr][nc], cnt + 1);
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}
}
