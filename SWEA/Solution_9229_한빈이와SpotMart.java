package staging;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와SpotMart {
	static int n, weight;
	static int[] cookies;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			cookies = new int[n];
			max = -1;

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++)
				cookies[i] = Integer.parseInt(st.nextToken());

			pick();
			System.out.println("#" + tc + " " + max);
		}
	}

	private static void pick() {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (cookies[i] + cookies[j] <= weight && cookies[i] + cookies[j] > max) {
					max = cookies[i] + cookies[j];
				}
			}
		}
	}
}
