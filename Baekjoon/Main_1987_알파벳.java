package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
	static int R, C;
	static char[][] map;
	static ArrayList<Character> list = new ArrayList<>();
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int count = 1;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		list.add(map[0][0]); // 첫 시작 알파벳 list에 추가
		dfs(0, 0); // 탐색 시작

		System.out.println(result);
	}

	private static void dfs(int r, int c) {
		int nr, nc;

		for (int i = 0; i < 4; i++) {
			nr = r + dir[i][0];
			nc = c + dir[i][1];

			if (nr > -1 && nr < R && nc > -1 && nc < C && !list.contains(map[nr][nc])) { // 리스트에 알파벳이 없으면
				count++;
				list.add(map[nr][nc]);

				dfs(nr, nc);

				count--;
				list.remove(list.indexOf(map[nr][nc]));
			}
		}

		result = Math.max(result, count);
	}

}
