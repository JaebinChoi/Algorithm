package algo0410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {

	static class Edge implements Comparable<Edge> {
		int v, weight;

		public Edge(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return weight + " ";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int sv = Integer.parseInt(br.readLine());

		List<Edge>[] list = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list[Integer.parseInt(st.nextToken())]
					.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Edge[] distance = new Edge[V + 1];

		for (int i = 1; i <= V; i++) {
			if (i == sv)
				distance[i] = new Edge(i, 0);
			else
				distance[i] = new Edge(i, Integer.MAX_VALUE);
			pq.add(distance[i]);
		}

		boolean[] check = new boolean[V + 1];
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();

			// 연결되지 않은 노드가 나올 경우
			if (edge.weight == Integer.MAX_VALUE)
				continue;

			for (Edge next : list[edge.v]) {
				if (!check[next.v] && distance[edge.v].weight + next.weight < distance[next.v].weight) {
					distance[next.v].weight = distance[edge.v].weight + next.weight;
					pq.remove(distance[next.v]);
					pq.add(distance[next.v]);
				}
			}
			check[edge.v] = true;
		}

		// 출력 처리
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (distance[i].weight == Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(distance[i].weight).append("\n");
		}
		System.out.println(sb.toString());
	}
}
