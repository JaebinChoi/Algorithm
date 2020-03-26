import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_1226_미로1 {
	static final int R = 16;
	static final int C = 16;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int sr, sc;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/미로1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			map = new int[R][C];
			visited = new boolean[R][C];
			flag = false;

			br.readLine();
			for (int i = 0; i < R; i++) {
				String line = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = line.charAt(j) - '0';
					if (line.charAt(j) == '2') {
						sr = i;
						sc = j;
					}
				}
			}

			dfs(sr, sc);
			System.out.println("#" + tc + " " + (flag ? 1 : 0));
		}
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;

		if (map[r][c] == 3) {
			flag = true;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];

			if (isIn(nr, nc) || map[nr][nc] == 1 || visited[nr][nc])
				continue;

			dfs(nr, nc);
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr < 0 || nr >= R || nc < 0 || nc >= C;
	}
}
