import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
	static int N, M, result;
	static boolean[][] networks;
	static boolean[] virus;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		networks = new boolean[N + 1][N + 1];
		virus = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			networks[v][u] = true;
			networks[u][v] = true;
		}

		virus[1] = true;
		dfs(1);

		for (int i = 2; i < N + 1; i++) {
			if (virus[i]) {
				++result;
			}
		}

		System.out.println(result);
	}

	private static void dfs(int v) {
		for (int i = 2; i < N + 1; i++) {
			if (networks[v][i] && !virus[i]) {
				virus[i] = true;
				dfs(i);
			}
		}
	}
}
