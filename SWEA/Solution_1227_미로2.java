import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_1227_미로2 {
	static final int N = 100;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean flag;
	static int er, ec;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/미로2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			map = new int[N][N];
			visited = new boolean[N][N];
			flag = false;

			br.readLine();
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
					if (line.charAt(j) == '3') {
						er = i;
						ec = j;
					}
				}
			}

			dfs(1, 1);
			System.out.println("#" + tc + " " + (flag ? 1 : 0));
		}
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;

		if (r == er && c == ec) {
			flag = true;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];

			if (isIn(nr, nc) || map[nr][nc] == 1 || visited[nr][nc])
				continue;

			dfs(nr, nc);
			visited[nr][nc] = false;
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr < 0 || nr >= N || nc < 0 || nc >= N;
	}
}
