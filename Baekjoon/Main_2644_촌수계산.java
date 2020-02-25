package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 그래프를 이용해서 BFS
public class Main_2644_촌수계산 {
	static int N;
	static boolean[][] relation;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/촌수계산.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		relation = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int stop = Integer.parseInt(st.nextToken());
		int relationNum = Integer.parseInt(br.readLine());

		for (int i = 0; i < relationNum; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			relation[n1][n2] = true;
			relation[n2][n1] = true;
		}

		search(start, stop);
	}

	private static void search(int start, int stop) {
		visited[start] = true;
		LinkedList<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { start, 0 });
		int temp[];

		while (!queue.isEmpty()) {
			temp = queue.poll();
			int node = temp[0];
			int link = temp[1];

			if (node == stop) {
				System.out.println(link);
				return;
			}

			for (int next = 1; next <= N; next++) {
				if (relation[node][next] && !visited[next]) { // 관계가 있고, 방문안했으면
					visited[next] = true;
					queue.offer(new int[] { next, link + 1 });
				}
			}
		}
		System.out.println(-1);
	}
}
