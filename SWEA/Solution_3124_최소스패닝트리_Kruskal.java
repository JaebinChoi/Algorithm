package algo0409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리_Kruskal {
	static int[] parents, rank;

	static class Edge implements Comparable<Edge> {
		int v1;
		int v2;
		long weight;

		public Edge(int v1, int v2, long weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}

	static void makeSet(int x) {
		parents[x] = x;
	}

	static int findSet(int x) {
		if (parents[x] == x)
			return x;

		parents[x] = findSet(parents[x]);
		return parents[x];
	}

	static void union(int x, int y) {
		int xx = findSet(x);
		int yy = findSet(y);
		if (rank[xx] > rank[yy]) {
			parents[yy] = xx;
		} else {
			parents[xx] = yy;
			if (rank[xx] == rank[yy]) {
				rank[yy]++;
			}
		}
	}

	static int V, E;
	static List<Edge> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			list = new ArrayList<Edge>();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

				list.add(new Edge(v1, v2, cost));
			}

			parents = new int[V + 1];
			rank = new int[V + 1];
			for (int i = 0; i < V; i++)
				makeSet(i);

			Collections.sort(list);

			int cnt = 0;
			long result = 0;
			for (int i = 0, size = list.size(); i < size; i++) {
				int v1 = findSet(list.get(i).v1);
				int v2 = findSet(list.get(i).v2);
				if (v1 == v2)
					continue;

				union(v1, v2);
				result += list.get(i).weight;
				cnt++;

				if (cnt == V - 1)
					break;
			}

			System.out.println("#" + tc + " " + result);
		}
	}
}
