package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DFS로 풀이함
public class Main_11724_연결요소의개수 {
	static int N;
	static int link;
	static boolean[][] node;
	static boolean[] visited;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		link = Integer.parseInt(st.nextToken());
		node = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < link; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			node[n1][n2] = true;
			node[n2][n1] = true;
		}

		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				search(i);
				count++;
			}
		}
		System.out.println(count);
	}

	private static void search(int curNode) {
		visited[curNode] = true;
		for (int i = 1; i <= N; i++) {
			if (node[curNode][i] && !visited[i]) {
				search(i);
			}
		}
	}
}
