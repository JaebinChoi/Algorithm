package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_3055_탈출 {
	static int R, C;
	static char[][] map;
	static boolean[][] visited; // 고슴도치 방문 여부
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/탈출.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];

		// 입력
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		// 탐색
		LinkedList<int[]> queue = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*') {
					queue.offer(new int[] { i, j, 0, -100 });
				}
				if (map[i][j] == 'S') {
					visited[i][j] = true;
					queue.offerFirst(new int[] { i, j, 0, 100 });
				}
			}
		}

		int result = escape(queue);
		if (result == -1)
			System.out.println("KAKTUS");
		else
			System.out.println(result);
	}

	private static int escape(LinkedList<int[]> queue) {
		int nr, nc;
		int[] temp;

		while (!queue.isEmpty()) {
			temp = queue.poll();
			int r = temp[0];
			int c = temp[1];
			int time = temp[2];

			int judge = temp[3];
			// 100 : 고슴도치, -100 : 물
			// ↓ 이 조건 때문에 생성
			// 고슴도치가 움직일 차례인데 물에 찬 경우
			if (judge == 100 && map[r][c] == '*')
				continue;

			// 고슴도치랑 물이 같이 사방으로 이동
			for (int i = 0; i < 4; i++) {
				nr = r + dir[i][0];
				nc = c + dir[i][1];

				// 공통사항 : 경계 밖일 경우
				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;

				// 고슴도치 사항 : 고슴도치가 비버의 집에 도착했을 경우 종료
				if (map[r][c] == 'S' && map[nr][nc] == 'D')
					return time + 1;

				// 공통사항 : 고슴도치 또는 땅이 아닐 경우(비버 집, 물, 돌)
				if (map[nr][nc] != 'S' && map[nr][nc] != '.')
					continue;

				// 고슴도치 사항 : 고슴도치가 움직이는거면
				if (map[r][c] == 'S') {
					if (visited[nr][nc]) // 방문 O
						continue;
					else // 방문 X
						visited[nr][nc] = true;
				}

				map[nr][nc] = map[r][c];
				queue.offer(new int[] { nr, nc, time + 1, judge });
			}
		}
		return -1;
	}
}
