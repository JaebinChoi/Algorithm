import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_10451_순열사이클 {
	static int result;
	static int[] connects;
	static HashSet<Integer> cycle;
	static LinkedList<Integer> visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			connects = new int[n + 1];
			visited = new LinkedList<>();
			cycle = new HashSet<>();
			result = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				connects[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= n; i++) {
				// 현재 노드가 가리키는 노드가 사이클로 형성되어 있지 않을 경우
				if (!cycle.contains(connects[i])) {
					visited.offer(connects[i]);
					dfs(i, connects[i]);
					visited.pollLast();
				}
			}

			System.out.println(result);
		}
	}

	private static void dfs(int start, int cur) {
		int next = connects[cur];

		// 탈출조건 : 사이클이 형성될 경우
		if (next == start) {
			visited.offer(start);
			cycle.addAll(visited);
			visited.pollLast();
			++result;
			return;
		}

		if (cycle.contains(next)) {
			return;
		}

		visited.offer(next);
		dfs(start, next);
		visited.pollLast();
	}
}
