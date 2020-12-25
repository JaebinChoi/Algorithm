import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1261_알고스팟 {
	static int N, M, result;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static class Node implements Comparable<Node> {
		int r;
		int c;
		int cnt;

		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cnt, o.cnt);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		bfs(0, 0);
		System.out.println(result);
	}

	private static void bfs(int r, int c) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		visited[r][c] = true;
		queue.offer(new Node(r, c, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			r = node.r;
			c = node.c;
			int cnt = node.cnt;

			if (r == N - 1 && c == M - 1) {
				result = cnt;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];

				if (!isIn(nr, nc) || visited[nr][nc]) continue;

				visited[nr][nc] = true;
				if (map[nr][nc] == 1) queue.offer(new Node(nr, nc, cnt + 1));
				else queue.offer(new Node(nr, nc, cnt));
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}
}
