package staging;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1647_도시분할계획 {

	static class City implements Comparable<City> {
		int from, to, cost;

		public City(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(City o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	static int[] parent, rank;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		List<City> list = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list.add(new City(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);
		
		parent = new int[V];
		rank = new int[V];
		for (int i = 0; i < V; i++)
			makeSet(i);

		int cnt = 0;
		int sum = 0;
		for (City city : list) {
			if (findSet(city.from) == findSet(city.to))
				continue;

			union(city.from, city.to);
			sum += city.cost;
			cnt++;

			if (cnt == V - 2)
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
