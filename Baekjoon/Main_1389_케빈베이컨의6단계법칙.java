package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1389_케빈베이컨의6단계법칙 {
	static int N;
	static int link;
	static boolean[][] relation;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		link = Integer.parseInt(st.nextToken());
		relation = new boolean[N + 1][N + 1];

		for (int i = 0; i < link; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			relation[r][c] = true;
			relation[c][r] = true;
		}

		int result = Integer.MAX_VALUE; // 거치는 관계 개수 중 가장 작은 값
		int resultNode = 0; // 가장 작은 값을 가진 노드
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			int count = search(i, 1);

			if (count < result) {
				result = count;
				resultNode = i;
			}

		}
		System.out.println(resultNode);
	}

	// BFS
	private static int search(int curNode, int cnt) { // 현재노드, 거치는 관계 수
		LinkedList<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { curNode, cnt });
		visited[curNode] = true;

		int temp[];
		int count = 0; // 거치는 관계 수의 합

		while (!queue.isEmpty()) {
			temp = queue.poll();
			curNode = temp[0];
			cnt = temp[1];

			for (int i = 1; i <= N; i++) {
				if (relation[curNode][i] && !visited[i]) {
					visited[i] = true;
					count += cnt;
					queue.offer(new int[] { i, cnt + 1 });
				}
			}
		}

		return count;
	}

}
