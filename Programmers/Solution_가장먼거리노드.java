import java.util.ArrayList;
import java.util.LinkedList;

class Solution_가장먼거리노드 {
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int result;

	public int solution(int n, int[][] edge) {
		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		// 인접 리스트로 구현
		for (int i = 0, size = edge.length; i < size; i++) {
			list[edge[i][0]].add(edge[i][1]);
			list[edge[i][1]].add(edge[i][0]);
		}

		bfs(1);
		return result;
	}

	private void bfs(int v) {
		LinkedList<Integer> queue = new LinkedList<>();
		visited[v] = true;
		queue.offer(v);

		while (!queue.isEmpty()) {
			// 가장 먼 거리의 노드 개수 저장
			result = queue.size();

			for (int t = 0, s1 = queue.size(); t < s1; t++) {
				v = queue.poll();

				for (int i = 0, s2 = list[v].size(); i < s2; i++) {
					int u = list[v].get(i);

					if (visited[u]) {
						continue;
					}

					visited[u] = true;
					queue.offer(u);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

		System.out.println(new Solution_가장먼거리노드().solution(6, edge));
	}
}