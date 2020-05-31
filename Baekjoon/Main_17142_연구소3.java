import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/** Brute-Force, BFS */
public class Main_17142_연구소3 {
	static int N, V, empty, result = Integer.MAX_VALUE;
	static int[][] map, dis;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static ArrayList<Virus> virusList = new ArrayList<>();
	static LinkedList<Virus> pick = new LinkedList<>();

	static class Virus {
		int x;
		int y;

		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virusList.add(new Virus(i, j));
					map[i][j] = -1;
				}
				if (map[i][j] == 0) empty++;
			}
		}

		if (empty == 0) System.out.println(0);
		else {
			combination(0, 0);
			System.out.println(result == Integer.MAX_VALUE ? -1 : result);
		}
	}

	private static void combination(int cur, int cnt) {
		if (cnt == V) {
			spread();
			return;
		}

		for (int i = cur, size = virusList.size(); i < size; i++) {
			Virus virus = virusList.get(i);
			pick.add(virus);
			combination(i + 1, cnt + 1);
			pick.remove(virus);
		}
	}

	private static void spread() {
		LinkedList<Virus> queue = new LinkedList<>();
		dis = new int[N][N];
		for (int i = 0; i < N; i++)
			dis[i] = map[i].clone();

		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < V; i++) {
			Virus virus = pick.get(i);
			visited[virus.x][virus.y] = true;
			dis[virus.x][virus.y] = 0;
			queue.offer(virus);
		}

		int emptyCnt = empty;
		int cnt = 0;

		while (!queue.isEmpty()) {
			for (int t = 0, size = queue.size(); t < size; t++) {
				Virus v = queue.poll();

				for (int i = 0; i < 4; i++) {
					int nr = v.x + dir[i][0];
					int nc = v.y + dir[i][1];

					if (!isIn(nr, nc) || map[nr][nc] > 0 || visited[nr][nc])
						continue;

					if (dis[nr][nc] == 0) emptyCnt--;
					visited[nr][nc] = true;
					dis[nr][nc] = cnt + 1;
					queue.offer(new Virus(nr, nc));
				}
			}
			cnt++;

			if (emptyCnt == 0) {
				result = result > cnt ? cnt : result;
				return;
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}
