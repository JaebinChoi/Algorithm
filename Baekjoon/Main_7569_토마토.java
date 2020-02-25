package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_7569_토마토 {
	static int R, C, boxNum;
	static int[][][] box;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[] moveBox = { 1, -1 };
	static int count;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/토마토.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		boxNum = Integer.parseInt(st.nextToken());
		box = new int[boxNum][R][C];

		for (int i = 0; i < boxNum; i++) {
			for (int j = 0; j < R; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < C; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		LinkedList<int[]> queue = new LinkedList<>();
		// 토마토 있는 곳 다 큐에 넣기
		for (int i = 0; i < boxNum; i++)
			for (int j = 0; j < R; j++)
				for (int k = 0; k < C; k++)
					if (box[i][j][k] == 1)
						queue.offer(new int[] { i, j, k });
		
		bfs(queue);

		// 안익은 토마토 여부 파악
		boolean flag = true;
		for (int i = 0; i < boxNum; i++)
			for (int j = 0; j < R; j++)
				for (int k = 0; k < C; k++)
					if (box[i][j][k] == 0)
						flag = false;

		if (!flag)
			count = 0;

		System.out.println(count - 1);

	}

	private static void bfs(LinkedList<int[]> queue) {
		int nb, nr, nc;
		int temp[];

		while (!queue.isEmpty()) {
			int size = queue.size(); // 하루치

			for (int t = 0; t < size; t++) {
				temp = queue.poll();
				int b = temp[0];
				int r = temp[1];
				int c = temp[2];

				// 상하좌우 탐색
				for (int i = 0; i < 4; i++) {
					nr = r + dir[i][0];
					nc = c + dir[i][1];

					if (nr < 0 || nr >= R || nc < 0 || nc >= C || box[b][nr][nc] != 0)
						continue;

					box[b][nr][nc] = 1;
					queue.offer(new int[] { b, nr, nc });
				}

				// 앞뒤 탐색
				for (int i = 0; i < 2; i++) {
					nb = b + moveBox[i];

					if (nb < 0 || nb >= boxNum || box[nb][r][c] != 0)
						continue;

					box[nb][r][c] = 1;
					queue.offer(new int[] { nb, r, c });
				}
			}
			// 큐 사이즈만큼 한바퀴 돌면 하루 지남
			count++;
		}
	}
}
