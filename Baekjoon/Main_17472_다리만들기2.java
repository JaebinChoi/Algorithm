import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17472_다리만들기2 {
	static int N, M, island, from, to;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static ArrayList<Node> list;

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int distance;

		public Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.distance, o.distance);
		}
	}

	static int[] parent, rank;
	static void makeSet(int x) {
		parent[x] = x;
	}

	static int findSet(int x) {
		if (x == parent[x])
			return x;

		parent[x] = findSet(parent[x]);
		return parent[x];
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (rank[px] > rank[py]) {
			parent[py] = px;
		} else {
			parent[px] = py;
			if (rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();

		// 데이터 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬 구분
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					island++;
					bfs(i, j);
				}
			}
		}

		// 섬 연결
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) {
					from = map[i][j];
					for (int k = 0; k < 4; k++) {
						int dis = connect(i, j, k, 0);

						if (dis > 1) {
							list.add(new Node(from, to, dis));
						}
					}
				}
			}
		}

		// MST
		Collections.sort(list);
		parent = new int[island + 1];
		rank = new int[island + 1];
		for (int i = 1; i <= island; i++) {
			makeSet(i);
		}

		int sum = 0;
		int cnt = 0;
		for (int i = 0, size = list.size(); i < size; i++) {
			int land1 = list.get(i).x;
			int land2 = list.get(i).y;

			if (findSet(land1) == findSet(land2))
				continue;

			union(land1, land2);
			sum += list.get(i).distance;
			cnt++;
			
			if(cnt == island - 1)
				break;
		}

		System.out.println(cnt == island - 1 ? sum : -1);
	}

	private static int connect(int r, int c, int di, int cnt) {
		r += dir[di][0];
		c += dir[di][1];

		if (!isIn(r, c)) // 배열 벗어남
			return 0;
		if (map[r][c] != 0) { // 섬을 만나면
			to = map[r][c];
			return cnt;
		}
		cnt = connect(r, c, di, cnt + 1);
		return cnt;
	}

	private static void bfs(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		visited[r][c] = true;
		map[r][c] = island;
		queue.offer(new int[] { r, c });

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			r = temp[0];
			c = temp[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];

				if (!isIn(nr, nc) || visited[nr][nc] || map[nr][nc] == 0)
					continue;

				visited[nr][nc] = true;
				map[nr][nc] = island;
				queue.offer(new int[] { nr, nc });
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}
}
