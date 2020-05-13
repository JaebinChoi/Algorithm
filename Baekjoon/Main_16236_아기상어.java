import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {
	static int N;
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
	static boolean[][] visited;
	static Node shark;
	static boolean isEatable;

	static class Node {
		int x;
		int y;
		int size;
		int deposit;
		int distance;

		public Node() {}
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Node(int x, int y, int distance) {
			this(x, y);
			this.distance = distance;
		}
		public Node(int x, int y, int size, int deposit, int distance) {
			this(x, y, distance);
			this.size = size;
			this.deposit = deposit;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Node(i, j);
					shark.size = 2;
				}
			}
		}

		isEatable = true;
		while (isEatable) {
			visited = new boolean[N][N];
			search(shark);
		}

		System.out.println(shark.distance);
	}

	private static void search(Node node) {
		LinkedList<Node> queue = new LinkedList<>(); // 사방탐색할 큐
		LinkedList<Node> fishes = new LinkedList<>(); // 같은 depth의 먹을 수 있는 물고기 큐
		visited[node.x][node.y] = true; // 방문처리
		queue.offer(node); // 상어가 움직인다~

		while (!queue.isEmpty()) {
			for (int n = 0, cycle = queue.size(); n < cycle; n++) {
				Node temp = queue.poll();
				int r = temp.x;
				int c = temp.y;
				int distance = temp.distance;

				for (int i = 0; i < 4; i++) {
					int nr = r + dir[i][0];
					int nc = c + dir[i][1];

					// 영역을 벗어나거나, 물고기가 상어보다 크면 pass
					if (!isIn(nr, nc) || visited[nr][nc] || map[nr][nc] > shark.size)
						continue;

					// 먹을 수 있는 물고기 모으기!
					if (map[nr][nc] > 0 && map[nr][nc] < shark.size)
						fishes.offer(new Node(nr, nc, distance + 1));

					// 상어가 돌아다닌다!
					visited[nr][nc] = true;
					queue.offer(new Node(nr, nc, distance + 1));
				} // 사방탐색
			} // cycle

			// 잡아먹을 물고기가 있을 경우
			if (fishes.size() != 0) {
				eat(fishes);
				isEatable = true;
				return;
			}
		} // while
		isEatable = false;
	}

	private static void eat(LinkedList<Node> fishes) {
		Node fish = new Node(); // 잡아먹을 물고기

		// 가장 가까운 물고기 pick(상 우선, 좌 우선)
		fish = fishes.get(0);
		for (int i = 1, len = fishes.size(); i < len; i++) {
			Node tmp = fishes.get(i);
			if (tmp.x < fish.x) { // 상 우선
				fish = tmp;
			} else if (tmp.x == fish.x) {
				if (tmp.y < fish.y) // 좌 우선
					fish = tmp;
			}
		}

		// 상어는 pick한 물고기를 잡아먹는다!
		map[fish.x][fish.y] = 9;
		map[shark.x][shark.y] = 0;
		if (++shark.deposit == shark.size) {
			shark.deposit = 0;
			shark.size++;
		}
		
		shark = new Node(fish.x, fish.y, shark.size, shark.deposit, fish.distance);
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}
}
