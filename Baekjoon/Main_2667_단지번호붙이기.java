package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main_2667_단지번호붙이기 {
	static int[][] map;
	static int N;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int cnt;

	static LinkedList<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/단지번호붙이기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					cnt = 0;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}

		int size = list.size();
		int[] count = new int[size];
		for (int i = 0; i < size; i++) {
			count[i] = list.get(i);
		}
		Arrays.sort(count);

		System.out.println(count.length);
		for (int i = 0; i < count.length; i++)
			System.out.println(count[i]);

	}

	private static void dfs(int row, int col) {
		int nr, nc;
		map[row][col] = 0;
		cnt++;
		for (int i = 0; i < 4; i++) {
			nr = row + dir[i][0];
			nc = col + dir[i][1];

			if (nr > -1 && nr < N && nc > -1 && nc < N && map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}

	}

}
