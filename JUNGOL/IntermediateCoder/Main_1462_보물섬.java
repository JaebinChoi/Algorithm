package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1462_보물섬 {
	static char[][] map;
	static boolean[][] visit;
	static int[][] temp;
	static int result;
	static int time;
	static int row;
	static int col;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/bank/보물섬.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new char[row][col];

		for (int i = 0; i < row; i++) {
			String line = br.readLine();
			for (int j = 0; j < col; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 'L') {
					visit = new boolean[row][col];
					temp = new int[row][col];
					temp[i][j] = 1;
					bfs(i, j);
					if(result < time) {
						result = time;
					}
				}
			}
		}
		System.out.println(result);

	}

	private static void bfs(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<int[]>();
		visit[r][c] = true;
		queue.offer(new int[] { r, c });

		int nr, nc;
		int[] tmp;

		while (!queue.isEmpty()) {
			tmp = queue.poll();
			r = tmp[0];
			c = tmp[1];

			for (int i = 0; i < 4; i++) {
				nr = r + dir[i][0];
				nc = c + dir[i][1];

				if (nr > -1 && nr < row && nc > -1 && nc < col && map[nr][nc] == 'L' && !visit[nr][nc]) {
					visit[nr][nc] = true;
					temp[nr][nc] = temp[r][c] + 1;
					time = temp[r][c];
					queue.offer(new int[] { nr, nc });
				}
			}
		}

	}

}
