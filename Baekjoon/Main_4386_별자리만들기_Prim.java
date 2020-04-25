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

// Prim 알고리즘
public class Main_4386_별자리만들기_Prim {

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

	// 연결된 별, 별까지 거리
	static class Edge implements Comparable<Edge> {
		int to;
		double cost;

		public Edge(int to, double cost) {
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

		List<Edge>[] list = new ArrayList[N];
		for (int i = 0; i < N; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				double dis = Math.sqrt(Math.pow(stars[i].x - stars[j].x, 2) + Math.pow(stars[i].y - stars[j].y, 2));
				list[i].add(new Edge(j, dis));
				list[j].add(new Edge(i, dis));
			}
		}

		boolean[] check = new boolean[N]; // visit
		double key[] = new double[N]; // cost

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (!check[cur.to]) {
				check[cur.to] = true;
				key[cur.to] = cur.cost;

				for (int j = 0, size = list[cur.to].size(); j < size; j++) {
					Edge edge = list[cur.to].get(j);
					if (!check[edge.to]) {
						pq.offer(new Edge(edge.to, edge.cost));
					}
				}
			}
		}

		double sum = 0;
		for (double c : key)
			sum += c;

		System.out.printf("%.2f", sum);
	}
}
