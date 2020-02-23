package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2583_영역구하기 {
	static int R, C, K;
	static boolean[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static ArrayList<Integer> list = new ArrayList<>();
	static int area;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[R][C];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sc = Integer.parseInt(st.nextToken());
			int sr = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			int er = Integer.parseInt(st.nextToken());

			for (int r = sr; r < er; r++) {
				for (int c = sc; c < ec; c++) {
					map[r][c] = true;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!map[i][j]) {
					count++;
					area = 1;
					search(i, j);
					list.add(area);
				}
			}
		}

		int size = list.size();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = list.get(i);
		}
		Arrays.sort(arr);

		System.out.println(count);
		for (int i : arr)
			System.out.print(i + " ");

	}

	private static void search(int r, int c) {
		int nr, nc;
		map[r][c] = true;

		for (int i = 0; i < 4; i++) {
			nr = r + dir[i][0];
			nc = c + dir[i][1];

			if (nr > -1 && nr < R && nc > -1 && nc < C && !map[nr][nc]) {
				area++;
				search(nr, nc);
			}
		}
	}

}
