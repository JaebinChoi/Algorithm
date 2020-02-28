package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// BFS
public class Main_1697_숨바꼭질 {
	static int N, K;
	static boolean[] visited = new boolean[100001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int result = bfs(N);
		System.out.println(result);
	}

	private static int bfs(int cur) {
		LinkedList<int[]> queue = new LinkedList<>();
		visited[cur] = true;
		queue.offer(new int[] { cur, 0 });
		int[] temp;

		while (!queue.isEmpty()) {
			temp = queue.poll();
			cur = temp[0];
			int time = temp[1];

			// 동생을 찾은 경우
			if (cur == K)
				return time;

			// 범위 안이고 방문 안한경우
			if (cur - 1 > -1 && !visited[cur - 1]) {
				visited[cur - 1] = true;
				queue.offer(new int[] { cur - 1, time + 1 });
			}
			if (cur + 1 < 100001 && !visited[cur + 1]) {
				visited[cur + 1] = true;
				queue.offer(new int[] { cur + 1, time + 1 });
			}
			if (cur * 2 < 100001 && !visited[cur * 2]) {
				visited[cur * 2] = true;
				queue.offer(new int[] { cur * 2, time + 1 });
			}
		}
		return -1;
	}
}
