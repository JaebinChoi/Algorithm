package algo0410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기 {

	static class City implements Comparable<City> {
		int city, cost;

		public City(int city, int cost) {
			this.city = city;
			this.cost = cost;
		}

		@Override
		public int compareTo(City o) {
			return Integer.compare(this.cost, o.cost);
		}

		@Override
		public String toString() {
			return cost + " ";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int C = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());

		List<City>[] list = new ArrayList[C];
		for (int i = 0; i < C; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < B; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list[Integer.parseInt(st.nextToken()) - 1]
					.add(new City(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
		}

		st = new StringTokenizer(br.readLine(), " ");
		int fromCity = Integer.parseInt(st.nextToken()) - 1;
		int toCity = Integer.parseInt(st.nextToken()) - 1;

		PriorityQueue<City> pq = new PriorityQueue<>();
		City[] city = new City[C];
		boolean[] check = new boolean[C];
		for (int i = 0; i < C; i++) {
			if (i == fromCity)
				city[i] = new City(i, 0);
			else
				city[i] = new City(i, Integer.MAX_VALUE);
			pq.add(city[i]);
		}

		while (!pq.isEmpty()) {
			City ct = pq.poll();

			// 연결되어 있지 않아 갈 수 없는 도시인 경우
			if (ct.cost == Integer.MAX_VALUE)
				continue;

			for (City next : list[ct.city]) {
				// 방문x, 현재까지의 비용 + 다음 도시까지의 비용이 기존의 다음 도시까지의 비용보다 작을 경우
				if (!check[next.city] && city[ct.city].cost + next.cost < city[next.city].cost) {
					city[next.city].cost = city[ct.city].cost + next.cost;
					pq.remove(city[next.city]);
					pq.add(city[next.city]);
				}
			}
			check[ct.city] = true;
		}
		System.out.println(city[toCity].cost);
	}
}
