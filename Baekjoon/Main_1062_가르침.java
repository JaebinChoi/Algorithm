import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1062_가르침 {
	static int N, K, result;
	static String[] words;
	static boolean[] visited;
	static ArrayList<Character> list = new ArrayList<>();
	static ArrayList<Character> pick = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new String[N];
		visited = new boolean[26];

		if (K < 5) {
			System.out.println(0);
			return;
		}
		if (K == 26) {
			System.out.println(N);
			return;
		}
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			word = word.replaceAll("[antic]", "");
			words[i] = word;
		}
		visited['a' - 'a'] = true;
		visited['n' - 'a'] = true;
		visited['t' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['c' - 'a'] = true;
		dfs(0, 5);
		System.out.println(result);
	}

	private static void dfs(int cur, int cnt) {
		if (cnt == K) {
			int temp = 0;
			for (int i = 0; i < N; i++) {
				boolean flag = true;
				for (int j = 0, len = words[i].length(); j < len; j++) {
					if (!visited[words[i].charAt(j) - 'a']) {
						flag = false;
						break;
					}
				}
				if (flag)
					temp++;
			}
			result = result > temp ? result : temp;
			return;
		}

		for (int i = cur, size = visited.length; i < size; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i + 1, cnt + 1);
				visited[i] = false;
			}
		}
	}
}
