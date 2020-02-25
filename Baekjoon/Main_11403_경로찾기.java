package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_11403_경로찾기 {
	static int N;
	static int[][] map;
	static int[][] result;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		result = new int[N + 1][N + 1];

		// 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// BFS
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				visited = new boolean[N + 1];
				bfs(i, j);
			}
		}

		// 출력
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void bfs(int start, int stop) {
		LinkedList<int[]> queue = new LinkedList<>();
		int cur = start;
		queue.offer(new int[] { cur });
		int[] temp;

		while (!queue.isEmpty()) {
			temp = queue.poll();
			cur = temp[0];

			for (int i = 1; i <= N; i++) {
				if (map[cur][i] == 1 && !visited[i]) {
					if (i == stop) {
						result[start][stop] = 1;
						queue.clear();
						return;
					}
					visited[i] = true;
					queue.offer(new int[] { i });
				}
			}
		}

	}

}
