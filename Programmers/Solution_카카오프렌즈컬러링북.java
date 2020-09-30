import java.util.Arrays;
import java.util.LinkedList;

class Solution_카카오프렌즈컬러링북 {
	static int R, C;
	static int[][] map;
	static int[][] dir;
	static boolean[][] visited;
	static int numberOfArea, maxSizeOfOneArea;

	public int[] solution(int m, int n, int[][] picture) {
		// 초기화를 여기서 안하면 실패 뜸..
		R = m; C = n;
		map = new int[R][C];
		dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		visited = new boolean[R][C];
		numberOfArea = 0; maxSizeOfOneArea = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = picture[i][j];
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					numberOfArea++;
					bfs(i, j);
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	private void bfs(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		visited[r][c] = true;
		queue.offer(new int[] { r, c });
		int cnt = 1;

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			r = temp[0];
			c = temp[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];

				if (!isIn(nr, nc) || visited[nr][nc]) continue;
				if (map[r][c] != map[nr][nc]) continue;

				visited[nr][nc] = true;
				queue.offer(new int[] { nr, nc });
				cnt++;
			}
		}
		maxSizeOfOneArea = maxSizeOfOneArea > cnt ? maxSizeOfOneArea : cnt;
	}

	private boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < R && nc < C;
	}

	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };

		System.out.println(Arrays.toString(new Solution_카카오프렌즈컬러링북().solution(m, n, picture)));
		;
	}
}