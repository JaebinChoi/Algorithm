import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_조합 {
	static int N, R;
	static final int MOD = 1234567891;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			long[] factorial = new long[N + 1];
			factorial[0] = 1;

			for (int i = 1; i <= N; i++) {
				factorial[i] = (i * factorial[i - 1]) % MOD;
			}

			// 페르마 소정리
			long parent = factorial[R] * factorial[N - R] % MOD;
			long child = fermat(parent, MOD - 2);
			System.out.println("#" + tc + " " + (factorial[N] * child) % MOD);
		}
	}

	// x^n 을 분할정복으로 구하는 메소드
	public static long fermat(long x, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return x;

		long ret = fermat(x, n >> 1);
		if (n % 2 == 0) {
			return (ret * ret) % MOD;
		} else {
			return (((ret * ret) % MOD) * x) % MOD;
		}
	}
}
