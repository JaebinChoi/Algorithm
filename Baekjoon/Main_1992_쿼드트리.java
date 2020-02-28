package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

// 분할정복
public class Main_1992_쿼드트리 {
	static int N;
	static int[][] map;
	static StringBuilder media = new StringBuilder();
	static int count;
	static ArrayDeque<Integer> stack = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/쿼드트리.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		divide(0, 0, N);
		System.out.println(media);
	}

	private static boolean dividable(int r, int c, int size) {
		for (int i = r; i < r + size; i++)
			for (int j = c; j < c + size; j++)
				if (map[r][c] != map[i][j])
					return false;
		return true;
	}

	private static void divide(int r, int c, int size) {
		boolean isAble = dividable(r, c, size);

		if (isAble) {
			media.append(map[r][c]);

			count++;
			while (count == 4) {
				media.append(")");
				count = stack.pop() + 1;
			}

		} else {
			media.append("(");
			stack.push(count);
			count = 0;

			size /= 2;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					divide(r + i * size, c + j * size, size);
				}
			}
		}
	}
}
