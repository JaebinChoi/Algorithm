import java.util.HashSet;
import java.util.Set;

class Solution_네트워크 {
	static int[] parent;
	static int[] rank;
	static Set<Integer> set;

	// 모든 노드를 root로 초기화
	public static void makeSet(int x) {
		parent[x] = x;
	}

	// 특정 노드의 root를 찾아 반환
	public static int findSet(int x) {
		if (parent[x] == x) {
			return x;
		}

		parent[x] = findSet(parent[x]);
		return parent[x];
	}

	// 두 그래프 또는 노드를 병합
	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		// 랭크가 높은 부모 밑으로 들어감
		if (rank[px] < rank[py]) {
			parent[px] = py;
		} else {
			parent[py] = px;

			// 랭크가 같으면 한 쪽의 랭크를 높여줌
			if (rank[px] == rank[py]) {
				rank[px]++;
			}
		}
	}

	public int solution(int n, int[][] computers) {
		parent = new int[n];
		rank = new int[n];
		set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			makeSet(i);
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (computers[i][j] == 1) {
					union(i, j);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			set.add(findSet(parent[i]));
		}

		return set.size();
	}

	public static void main(String[] args) {
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println(new Solution_네트워크().solution(3, computers));
	}
}