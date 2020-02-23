package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10026_적록색약 {
	static int N;
	static char[][] mapRGB;
	static char[][] mapRB;
	static boolean[][] visitedRGB;
	static boolean[][] visitedRB;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mapRGB = new char[N][N];
		mapRB = new char[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				char ch = line.charAt(j);
				mapRGB[i][j] = ch;

				if (ch == 'G')
					mapRB[i][j] = 'R';
				else
					mapRB[i][j] = ch;
			}
		}

		visitedRGB = new boolean[N][N];
		visitedRB = new boolean[N][N];
		int cntRGB = 0;
		int cntRB = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visitedRGB[i][j]) {
					cntRGB++;
					search(i, j, mapRGB, visitedRGB);
				}
				if (!visitedRB[i][j]) {
					cntRB++;
					search(i, j, mapRB, visitedRB);
				}
			}
		}
		System.out.println(cntRGB + " " + cntRB);
	}

	private static void search(int r, int c, char[][] map, boolean[][] visited) {
		int nr, nc;
		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			nr = r + dir[i][0];
			nc = c + dir[i][1];

			if (nr > -1 && nr < N && nc > -1 && nc < N && !visited[nr][nc] && map[nr][nc] == map[r][c]) {
				search(nr, nc, map, visited);
			}
		}
	}

}
