import java.util.ArrayList;
import java.util.Collections;

class Solution_여행경로 {
	static String[][] tickets;
	static int N;
	static ArrayList<String> routes = new ArrayList<>();
	static boolean[] visited;

	public String[] solution(String[][] inputs) {
		tickets = inputs;
		N = tickets.length;
		visited = new boolean[N];

		dfs("ICN", "ICN", 0);
		Collections.sort(routes);

		return routes.get(0).split(" ");
	}

	private void dfs(String depart, String route, int cnt) {
		if (cnt == N) {
			routes.add(route);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i] || !tickets[i][0].equals(depart)) {
				continue;
			}

			visited[i] = true;
			dfs(tickets[i][1], route + " " + tickets[i][1], cnt + 1);
			visited[i] = false;
		}

	}

	public static void main(String[] args) {
		String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } };

		System.out.println(new Solution_여행경로().solution(tickets));
	}
}