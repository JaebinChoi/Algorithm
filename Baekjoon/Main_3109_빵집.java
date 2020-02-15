package jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	static char[][] map;
	static int row, col;
	static int[][] dir = { { 1, 1 }, { 0, 1 }, { -1, 1 } }; // 스택 사용했기 때문에 방향은 오른쪽 아래, 오른쪽, 오른쪽 위 순으로 써야 오른쪽 위부터 pop 
	static int count;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/빵집.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new char[row][col];

		for (int i = 0; i < row; i++) {
			String str = br.readLine();
			for (int j = 0; j < col; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		// 0열 기준 행단위로 dfs
		for (int i = 0; i < row; i++) {
			dfs(i);
		}
		System.out.println(count);

	}

	private static void dfs(int start) {
		Stack<int[]> stack = new Stack<int[]>();
		stack.push(new int[] { start, 0 });
		int r, c, nr, nc;
		int[] temp;

		while (!stack.isEmpty()) {
			temp = stack.pop();
			r = temp[0];
			c = temp[1];
			map[r][c] = 'x';

			for (int i = 0; i < 3; i++) {
				nr = r + dir[i][0];
				nc = c + dir[i][1];

				if (nr > -1 && nr < row && map[nr][nc] != 'x') {
					if (nc == col - 1) { // N-1 열에 도착했으면
						map[nr][nc] = 'x';
						count++;
						return;
					}
					stack.push(new int[] { nr, nc });
				}
			}
		}

	}
}
