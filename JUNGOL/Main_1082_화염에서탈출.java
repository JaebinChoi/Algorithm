package jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 화염에서탈출(SLIKAR)
public class Main_1082_화염에서탈출 {
	static int R, C;
	static char[][] map;
	static int[][] visited;
	static LinkedList<int[]> queue;
	static int time;
	static int SR, SC;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/화염에서탈출.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new int[R][C];
		queue = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') { // 시작 위치 찾기
					SR = i;
					SC = j;
					queue.offerFirst(new int[] { i, j }); // 가장 앞에 삽입
				} else if (map[i][j] == '*') {
					queue.offer(new int[] { i, j });
				}
			}
		}

		bfs();
		
		if(time == 0)
			System.out.println("impossible");
		else
			System.out.println(time);

	}

	private static void bfs() {
		int r, c, nr, nc, t;
		int[] temp;
		visited[SR][SC] = 1;

		while (!queue.isEmpty()) {
			temp = queue.poll();
			r = temp[0];
			c = temp[1];
			t = visited[r][c];

			for (int i = 0; i < 4; i++) {
				nr = r + dir[i][0];
				nc = c + dir[i][1];

				// 사람 차례
				if (map[r][c] == 'S') {
					if (nr > -1 && nr < R && nc > -1 && nc < C && (map[nr][nc] == '.' || map[nr][nc] == 'D')) { // 움직일 위치가 경계안이고 길 또는 도착지일때
						if (map[nr][nc] == 'D') { // 도착지일때
							time = t;
							queue.clear();
							return;
						}
						// 길일때
						visited[nr][nc] = t + 1;
						map[nr][nc] = 'S';
						queue.offer(new int[] { nr, nc });
					}
				} else if (map[r][c] == '*' && visited[r][c] == 0) { // 화염 차례
					if (nr > -1 && nr < R && nc > -1 && nc < C && (map[nr][nc] == '.' || map[nr][nc] == 'S')) {
						map[nr][nc] = '*';
						queue.offer(new int[] { nr, nc });
					}
				} else if (map[r][c] == '*' && visited[r][c] != 0) { // 사람 차례인데 화염으로 덮인 곳이라 패스하는 부분
					visited[r][c] = 0;
					break;
				}

			}

		}
	}

}
