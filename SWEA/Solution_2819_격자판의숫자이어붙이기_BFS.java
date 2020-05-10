import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_2819_격자판의숫자이어붙이기_BFS {
	static final int N = 4;
	static String[][] map;
	static HashSet<String> set;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			map = new String[N][N];
			set = new HashSet<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j);
				}
			}
			System.out.println("#" + tc + " " + set.size());
		}
	}

	private static void bfs(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		LinkedList<String> qString = new LinkedList<>();
		queue.offer(new int[] { r, c, 0 });
		qString.offer(new String(map[r][c]));

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			r = temp[0];
			c = temp[1];
			String str = qString.poll();

			if (str.length() == 7) {
				set.add(str);
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];

				if (!isIn(nr, nc))
					continue;

				queue.offer(new int[] { nr, nc });
				qString.offer(new String(str.concat(map[nr][nc])));
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}
}
