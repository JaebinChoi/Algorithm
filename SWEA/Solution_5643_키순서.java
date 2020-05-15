package staging;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_5643_키순서 {
	static int N, M, cnt;
	static ArrayList<Integer>[] talls, smalls;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());

			talls = new ArrayList[N + 1];
			smalls = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				talls[i] = new ArrayList<>();
				smalls[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int small = Integer.parseInt(st.nextToken());
				int tall = Integer.parseInt(st.nextToken());
				talls[small].add(tall);
				smalls[tall].add(small);
			}

			int result = 0;
			for (int i = 1; i <= N; i++) {
				visited = new boolean[N + 1];
				cnt = 0;

				connectTall(i);
				connectSmall(i);

				if (cnt == N - 1)
					result++;
			}
			System.out.println("#" + tc + " " + result);
		}
	}

	private static void connectTall(int cur) {
		for (int i = 0, size = talls[cur].size(); i < size; i++) {
			int n = talls[cur].get(i);
			if (visited[n]) continue;
			cnt++;
			visited[n] = true;
			connectTall(n);
		}
	}

	private static void connectSmall(int cur) {
		for (int i = 0, size = smalls[cur].size(); i < size; i++) {
			int n = smalls[cur].get(i);
			if (visited[n]) continue;
			cnt++;
			visited[n] = true;
			connectSmall(n);
		}
	}
}
