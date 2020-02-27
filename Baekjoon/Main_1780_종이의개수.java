package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780_종이의개수 {
	static int N;
	static int[][] paper;
	static int[] count = new int[3];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/종이의개수.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				paper[i][j] = Integer.parseInt(st.nextToken()) + 1;
		}

		cut(0, 0, N);

		for (int i = 0; i < 3; i++)
			System.out.println(count[i]);
	}

	private static boolean cuttable(int r, int c, int size) {
		for (int i = r; i < r + size; i++)
			for (int j = c; j < c + size; j++)
				if (paper[r][c] != paper[i][j])
					return false;
		return true;
	}

	private static void cut(int r, int c, int size) {
		boolean isCuttable = cuttable(r, c, size);

		if (isCuttable) {
			count[paper[r][c]]++;
		} else {
			size /= 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					cut(r + (size * i), c + (size * j), size);
				}
			}
		}

	}
}
