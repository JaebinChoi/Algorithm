package staging;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Kruskal
public class Main_1922_네트워크연결_Kruskal {

	static class Computer implements Comparable<Computer> {
		int from, to, cost;

		public Computer(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Computer o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	static int[] parent, rank;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());

		List<Computer> list = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list.add(new Computer(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);

		parent = new int[V];
		rank = new int[V];
		for (int i = 0; i < V; i++)
			makeSet(i);

		int cnt = 0;
		int sum = 0;
		for (Computer com : list) {

			if (findSet(com.from) == findSet(com.to))
				continue;

			union(com.from, com.to);
			sum += com.cost;
			cnt++;

			if (cnt == V - 1)
				break;
		}
		System.out.println(sum);
	}

	static void makeSet(int x) {
		parent[x] = x;
	}

	static int findSet(int x) {
		if (x == parent[x])
			return x;
		else {
			parent[x] = findSet(parent[x]);
			return parent[x];
		}
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (rank[px] > rank[py])
			parent[py] = px;
		else {
			parent[px] = py;

			if (rank[px] == rank[py])
				rank[py]++;
		}
	}
}
