package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Brute Force
public class Main_1018_체스판다시칠하기 {
	static int N, M;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/체스판다시칠하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		boolean whiteFirst = true;
		int result = Integer.MAX_VALUE;

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				result = Math.min(result, paint(whiteFirst, i, j));
				result = Math.min(result, paint(!whiteFirst, i, j));
			}
		}
		System.out.println(result);
	}

	private static int paint(boolean flag, int r, int c) {
		int count = 0;
		for (int i = r; i < r + 8; i++) {
			for (int j = c; j < c + 8; j++) {
				if (flag) { // 흰색 먼저
					if (j % 2 == 0 && map[i][j] != 'W') { // 짝수칸에 검은색이면 다시 칠하기
						count++;
					} else if (j % 2 == 1 && map[i][j] != 'B') { // 홀수칸에 흰색이면 다시 칠하기
						count++;
					}
				} else { // 검은색 먼저
					if (j % 2 == 0 && map[i][j] != 'B') { // 짝수칸에 흰색이면 다시 칠하기
						count++;
					} else if (j % 2 == 1 && map[i][j] != 'W') { // 홀수칸에 검은색이면 다시 칠하기
						count++;
					}
				}
			}
			flag = !flag; // 다음 줄에 시작 색깔 바꾸기
		}
		return count;
	}
}
