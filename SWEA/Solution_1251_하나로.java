package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1251_하나로 {
	static int N;
	static double E;
	static long[][] island;
	static long[][] distance;

	static class Edge implements Comparable<Edge> {
		int idx;
		long cost;

		public Edge(int idx, long cost) {
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/하나로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			island = new long[N][2];

			StringTokenizer xPos = new StringTokenizer(br.readLine(), " ");
			StringTokenizer yPos = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				island[i][0] = Long.parseLong(xPos.nextToken());
				island[i][1] = Long.parseLong(yPos.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			distance = new long[N][N];

			// 섬 간의 거리
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					distance[i][j] = distance[j][i] = (island[j][0] - island[i][0]) * (island[j][0] - island[i][0])
							+ (island[j][1] - island[i][1]) * (island[j][1] - island[i][1]);
				}
			}
			double cost = E * prim(0);

			System.out.println("#" + tc + " " + Math.round(cost));
		}
	}

	private static double prim(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Edge[] graph = new Edge[N];

		for (int i = 0; i < N; i++) {
			graph[i] = new Edge(i, Long.MAX_VALUE);
			if (i == start)
				graph[i].cost = 0;
			pq.add(graph[i]);
		}
		long cost = 0;
		while (!pq.isEmpty()) {
			Edge e1 = pq.poll();
			cost += e1.cost;

			for (int i = 0; i < N; i++) {
				Edge e2 = graph[i];
				if (pq.contains(e2)) {
					long tempCost = distance[e1.idx][e2.idx];
					if (tempCost < e2.cost) {
						e2.cost = tempCost;
						pq.remove(e2);
						pq.add(e2);
					}
				}
			}
		}
		return cost;
	}
}
