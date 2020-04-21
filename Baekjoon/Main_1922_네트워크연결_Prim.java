package staging;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Kruskal
public class Main_1922_네트워크연결_Prim {

	static class Computer implements Comparable<Computer> {
		int to, cost;

		public Computer(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Computer o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());

		List<Computer>[] list = new ArrayList[V];
		for (int i = 0; i < V; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken()) - 1;
			int v2 = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			list[v1].add(new Computer(v2, cost));
			list[v2].add(new Computer(v1, cost));
		}

		PriorityQueue<Computer> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V];
		pq.offer(new Computer(0, 0));

		int sum = 0;
		while (!pq.isEmpty()) {
			Computer com = pq.poll();

			if (!check[com.to]) {
				check[com.to] = true;
				sum += com.cost;

				for (Computer next : list[com.to]) {
					if (!check[next.to])
						pq.offer(new Computer(next.to, next.cost));
				}
			}
		}
		System.out.println(sum);
	}
}
