package staging;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Kruskal 알고리즘
public class Main_4386_별자리만들기_Kruskal {
	static int[] parent;
	static int[] rank;

	// 별 좌표
	static class Star {
		double x, y;

		public Star(double x, double y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Star [x=" + x + ", y=" + y + "]";
		}
	}

	// 간선 정보
	static class Edge implements Comparable<Edge> {
		int from, to;
		double cost;

		public Edge(int from, int to, double cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}

		@Override
		public String toString() {
			return cost + " ";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Star[] stars = new Star[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			stars[i] = new Star(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				double dis = Math.sqrt(Math.pow(stars[i].x - stars[j].x, 2) + Math.pow(stars[i].y - stars[j].y, 2));
				pq.add(new Edge(i, j, dis));
			}
		}

		parent = new int[N];
		rank = new int[N];
		for (int i = 0; i < N; i++)
			makeSet(i);

		int cnt = 0;
		double result = 0;
		while (cnt != N - 1) {
			Edge edge = pq.poll();

			if (findSet(edge.from) == findSet(edge.to))
				continue;

			result += edge.cost;
			union(edge.from, edge.to);
			cnt++;
		}

		System.out.printf("%.2f", result);
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
		int xx = findSet(x);
		int yy = findSet(y);

		if (rank[xx] > rank[yy]) {
			parent[yy] = xx;
		} else {
			parent[xx] = yy;

			if (rank[xx] == rank[yy]) {
				rank[yy]++;
			}
		}
	}
}
