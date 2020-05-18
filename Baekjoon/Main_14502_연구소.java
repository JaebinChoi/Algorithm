import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static int R, C, result;
	static int[][] map, copy;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static LinkedList<Node> queueViruses = new LinkedList<>();
	static LinkedList<Node> copyQueue = new LinkedList<>();
	static ArrayList<Node> listSafetyArea = new ArrayList<>();

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		copy = new int[R][C];
		result = Integer.MIN_VALUE;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) queueViruses.offer(new Node(i, j));
				else if (map[i][j] == 0) listSafetyArea.add(new Node(i, j));
			}
		}

		combination(0, 0);
		System.out.println(result);
	}

	private static void combination(int cur, int cnt) {
		if (cnt == 3) {
			copyMap();
			copyQueue.addAll(queueViruses);
			
			bfs(copyQueue);
			
			int count = countSafetyArea(copy);
			result = result < count ? count : result;
			return;
		}

		for (int i = cur, size = listSafetyArea.size(); i < size; i++) {
			Node node = listSafetyArea.get(i);
			map[node.x][node.y] = 1;
			combination(i + 1, cnt + 1);
			map[node.x][node.y] = 0;
		}
	}

	private static int countSafetyArea(int[][] copy) {
		int count = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (copy[i][j] == 0)
					count++;
			}
		}
		return count;
	}

	private static void copyMap() {
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				copy[i][j] = map[i][j];
	}

	private static void bfs(LinkedList<Node> queue) {
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = node.x + dir[i][0];
				int nc = node.y + dir[i][1];

				if (!isIn(nr, nc) || copy[nr][nc] != 0)
					continue;

				copy[nr][nc] = 2;
				queue.offer(new Node(nr, nc));
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < R && nc < C;
	}
}
