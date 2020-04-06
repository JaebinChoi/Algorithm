import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9659_다항식계산 {
	static final int MOD = 998244353;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/다항식.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			int[] t = new int[n + 1];
			int[] a = new int[n + 1];
			int[] b = new int[n + 1];

			for (int i = 2; i <= n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				t[i] = Integer.parseInt(st.nextToken());
				a[i] = Integer.parseInt(st.nextToken());
				b[i] = Integer.parseInt(st.nextToken());
			}

			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < m; i++) {
				int x = Integer.parseInt(st.nextToken());
				long[] f = new long[n + 1];
				Arrays.fill(f, -1);
				f[0] = 1;
				f[1] = x;

				for (int j = 2; j <= n; j++) {
					switch (t[j]) {
					case 1:
						f[j] = (f[a[j]] + f[b[j]]) % MOD;
						break;
					case 2:
						f[j] = (a[j] * f[b[j]]) % MOD;
						break;
					case 3:
						f[j] = (f[a[j]] * f[b[j]]) % MOD;
						break;
					}
				}
				sb.append(f[n]).append(" ");
			} // M
			System.out.println(sb.toString());
		} // testcase
	} // main
} // class
