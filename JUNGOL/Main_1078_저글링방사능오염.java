package jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 저글링 방사능 오염
public class Main_1078_저글링방사능오염 {
	static int R, C;
	static int[][] map;
	static int count;
	static int time;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/저글링.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		st = new StringTokenizer(br.readLine());
		int startCol = Integer.parseInt(st.nextToken()) - 1;
		int startRow = Integer.parseInt(st.nextToken()) - 1;

		bfs(startRow, startCol);

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 1) {
					count++;
				}
			}
		}

		System.out.println(time);
		System.out.println(count);

	}

	private static void bfs(int startRow, int startCol) {
		LinkedList<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { startRow, startCol });
		map[startRow][startCol] = 3;
		int r, c, nr, nc, t;
		int[] temp;

		while (!queue.isEmpty()) {
			temp = queue.pop();
			r = temp[0];
			c = temp[1];
			t = map[r][c];

			for (int i = 0; i < 4; i++) {
				nr = r + dir[i][0];
				nc = c + dir[i][1];

				if (nr > -1 && nr < R && nc > -1 && nc < C && map[nr][nc] == 1) {
					map[nr][nc] = t + 1;
					queue.offer(new int[] { nr, nc });
				}
			}
			time = t; // bfs 맨 마지막에 끝나는 시간
		}
	}

}
