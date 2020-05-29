package staging;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	static int R, C, cR, cC, time, result;
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			cR = Integer.parseInt(st.nextToken());
			cC = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());
			

			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			move();
			System.out.println("#" + tc + " " + result);
		}
	}

	private static void move() {
		LinkedList<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		visited[cR][cC] = true;
		queue.offer(new Node(cR, cC));
		
		result = 1; // 가능한 위치 수
		int cnt = 1; // 시간
		while (!queue.isEmpty()) {
			if (cnt >= time) return;
			
			for (int t = 0, size = queue.size(); t < size; t++) {
				Node node = queue.poll();
				int cur = map[node.r][node.c];

				for (int di = 0; di < 4; di++) {
					int nr = node.r + dir[di][0];
					int nc = node.c + dir[di][1];

					if (!isIn(nr, nc) || visited[nr][nc] || map[nr][nc] == 0)
						continue;

					int next = map[nr][nc];
					
					// 파이프가 연결되어 있는지 확인
					if (isConnect(di, cur, next)) {
						visited[nr][nc] = true;
						queue.offer(new Node(nr, nc));
						result++;
					}
				}
			}
			cnt++;
		}
	}

	private static boolean isConnect(int dir, int cur, int next) {
		boolean flag = false;
		switch(dir) {
		case 0: // 이동 방향 : 상
			if(cur == 1 || cur == 2 || cur == 4 || cur == 7) { // 이동 방향이 있는 파이프
				if(next == 1 || next == 2 || next == 5 || next == 6) { // 이동 방향으로 이동 할 수 있는 파이프
					flag = true;
				}
			}
			break;
		case 1:
			if(cur == 1 || cur == 2 || cur == 5 || cur == 6) {
				if(next == 1 || next == 2 || next == 4 || next == 7) {
					flag = true;
				}
			}
			break;
		case 2:
			if(cur == 1 || cur == 3 || cur == 6 || cur == 7) {
				if(next == 1 || next == 3 || next == 4 || next == 5) {
					flag = true;
				}
			}
			break;
		case 3:
			if(cur == 1 || cur == 3 || cur == 4 || cur == 5) {
				if(next == 1 || next == 3 || next == 6 || next == 7) {
					flag = true;
				}
			}
			break;
		}
		return flag;
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < R && nc < C;
	}
}
