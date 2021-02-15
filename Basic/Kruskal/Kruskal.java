import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Kruskal {
	static int[] parents;
	static int[] rank;

	static void makeSet(int x) {
		parents[x] = x;
	}

	static int findSet(int x) {
		if (x == parents[x])
			return x;
		else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}

	// Union-by-rank 최적화
	// 항상 높이가 더 낮은 트리를 높이가 높은 트리 밑에 넣는다
	// 즉, 높이가 더 높은 쪽은 root로 삼음
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if (rank[px] > rank[py]) {
			parents[py] = px; // y의 루트를 x로 변경
		} else {
			parents[px] = py; // x의 루트를 y로 변경
			
			// 만약 높이가 같으면 x의 루트를 y로 변경 후 y의 높이 + 1
			if (rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}

	// 입력은 첫줄에 정점의 개수와 간선의 개수가 들어오고
	// 그 다음줄부터 간선의 정보가 정점1 정점2 가중치로 간선의 개수만큼 들어옴
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] edges = new int[E][3];
		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt(); // 가중치
		}

		// 간선들을 가중치 오름차순 정렬
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// o1[2] o2[2]
				return Integer.compare(o1[2], o2[2]);
			}
		});

		// 각 정점에 대해 유니온파인드 연산 준비
		for (int i = 0; i < V; i++)
			makeSet(i);

		int cnt = 0;
		int result = 0;
		for (int i = 0; i < E; i++) {
			// 간선이 연결하는 두 정점이 같은 팀이 아니라면 한팀으로 합쳐주고 간선선택
			// 같은팀이라면 패스
			int a = findSet(edges[i][0]);
			int b = findSet(edges[i][1]);
			if (a == b)
				continue;

			union(a, b);
			// 간선을 선택
			result += edges[i][2];

			// 정점의 개수 -1번 반복하면서
			cnt++;
			if (cnt == V - 1)
				break;
		}
		
		System.out.println(result);
	}
}
