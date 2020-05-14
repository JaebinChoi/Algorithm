package staging;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/** BFS + BitMask */
public class Main_1194_달이차오른다가자 {
	static int R, C;
	static char[][] map;
	static boolean[][][] visited;
	static int[][] dir = { { -1, 0 }, { 1, -0 }, { 0, -1 }, { 0, 1 } };
	static LinkedList<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		queue = new LinkedList<>();
		visited = new boolean[R][C][64]; // 위치 별 가지고 있는 키개수(1: a, 2: b, 3: a,b ...)
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '0') {
					visited[i][j][0] = true;
					queue.offer(new int[] { i, j, 0 });
				}
			}
		}
		System.out.println(bfs());
	}

	private static int bfs() {
		int time = 0;
		while (!queue.isEmpty()) {
			for (int n = 0, size = queue.size(); n < size; n++) {
				int[] temp = queue.poll();
				int r = temp[0];
				int c = temp[1];
				int key = temp[2];

				if (isExit(r, c))
					return time;

				for (int i = 0; i < 4; i++) {
					int nr = r + dir[i][0];
					int nc = c + dir[i][1];
					int nk = key;

					if (!isIn(nr, nc) || visited[nr][nc][nk] || map[nr][nc] == '#')
						continue;

					if (isKey(nr, nc)) // 해당 키를 저장(bitmasking)
						nk |= (1 << (map[nr][nc] - 'a'));

					if (isDoor(nr, nc)) { // 해당 키 가지고 있는지 검사(bitmasking)
						if ((nk & (1 << (map[nr][nc] - 'a'))) == 0)
							continue;
					}

					visited[nr][nc][nk] = true;
					queue.offer(new int[] { nr, nc, nk });
				}
			}
			time++;
		}
		return -1;
	}

	private static boolean isExit(int nr, int nc) {
		return map[nr][nc] == '1';
	}

	private static boolean isKey(int nr, int nc) {
		return map[nr][nc] >= 'a' && map[nr][nc] <= 'z';
	}

	private static boolean isDoor(int nr, int nc) {
		return map[nr][nc] >= 'A' && map[nr][nc] <= 'Z';
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < R && nc < C;
	}
}
