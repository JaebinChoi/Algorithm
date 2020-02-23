package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1210_Ladder_DFS {
	static int[][] ladder;
	static boolean[][] visited;
	static int N = 100;
	static int[][] dir = { { 0, -1 }, { 0, 1 }, { 1, 0 } };
	static int result;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Ladder1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ladder = new int[N][N];
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				if (ladder[0][i] == 1) {
					visited = new boolean[N][N];
					if (dfs(0, i)) {
						result = i;
						break;
					}
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}

	private static boolean dfs(int row, int col) {
		int nr, nc;
		visited[row][col] = true;
		if (ladder[row][col] == 2) {
			return true;
		}

		for (int i = 0; i < 3; i++) {
			nr = row + dir[i][0];
			nc = col + dir[i][1];

			if (nr > -1 && nr < N && nc > -1 && nc < N && ladder[nr][nc] > 0 && !visited[nr][nc]) {
				return dfs(nr, nc);
			}
		}
		return false;

	}

}
