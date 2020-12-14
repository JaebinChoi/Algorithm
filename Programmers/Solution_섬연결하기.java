import java.util.Arrays;
import java.util.Comparator;

class Solution_섬연결하기 {
	static int[] parent;
	static int[] rank;

	public static int findSet(int x) {
		if (parent[x] == x) {
			return x;
		}

		parent[x] = findSet(parent[x]);
		return parent[x];
	}

	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (rank[px] < rank[py]) {
			parent[px] = py;
		} else {
			parent[py] = px;

			if (rank[px] == rank[py]) {
				rank[px]++;
			}
		}
	}

	public int solution(int v, int[][] costs) {
		parent = new int[v];
		rank = new int[v];

		// 비용이 적은 순서로 정렬
		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});

		// 모든 노드를 root로 초기화
		for (int i = 0; i < v; i++) {
			parent[i] = i;
		}

		int cnt = 0;
		int cost = 0;
		for (int[] edge : costs) {
			int px = findSet(edge[0]);
			int py = findSet(edge[1]);

			// 부모가 같은 경우(같은 그래프로 연결된 경우)
			if (px == py) {
				continue;
			}

			union(edge[0], edge[1]);
			cost += edge[2];
			++cnt;

			// 최소 신장 트리 => 간선 개수 = 정점 개수 - 1 (순환 x)
			if (cnt == v - 1) {
				break;
			}
		}

		return cost;
	}

	public static void main(String[] args) {
		int[][] costs = { { 0, 1, 5 }, { 0, 3, 2 }, { 0, 4, 3 }, { 1, 4, 1 }, { 3, 4, 10 }, { 1, 2, 2 }, { 2, 5, 3 },
				{ 4, 5, 4 } };
		System.out.println(new Solution_섬연결하기().solution(6, costs));
	}
}