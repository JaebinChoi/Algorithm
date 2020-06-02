import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {
	static int N, result;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 1, 1 }, { 1, 0 } };

	static class Node {
		int r;
		int c;
		int dir;

		public Node(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream(""));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(new Node(0, 1, 0));
		System.out.println(result);
	}

	private static void dfs(Node pipe) {
		if (pipe.r == N - 1 && pipe.c == N - 1) {
			result++;
			return;
		}

		for (int di = 0; di < 3; di++) {
			if (!movable(pipe.dir, di)) continue;

			int nr = pipe.r + dir[di][0];
			int nc = pipe.c + dir[di][1];
			if (!isIn(nr, nc) || !isEmpty(nr, nc, di)) continue;
			
			dfs(new Node(nr, nc, di));
		}
	}

	private static boolean isEmpty(int nr, int nc, int di) {
		if (di == 1) return map[nr][nc] == 0 && map[nr - 1][nc] == 0 && map[nr][nc - 1] == 0;
		else return map[nr][nc] == 0;
	}

	private static boolean isIn(int nr, int nc) {
		return nr < N && nc < N;
	}

	// 옮길 수 있는지(직각이면 불가능)
	private static boolean movable(int from, int to) {
		if ((from == 0 && to == 2) || (from == 2 && to == 0)) return false;
		return true;
	}
}
