import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** DP */
public class Main_5557_1학년 {
	static int N, result;
	static int[] numbers;
	static long[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		dp = new long[N - 1][21];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());

		dp[0][numbers[0]] = 1;
		for (int level = 1; level < N - 1; level++) { // level + 1번째 숫자를 계산
			for (int num = 0; num < 21; num++) { // 계산 가능한 숫자 찾기
				if (dp[level - 1][num] == 0) continue; // 계산한적 없는 숫자
				// 범위에 포함할 경우, 이전에 계산한 개수를 더해줌
				if (num + numbers[level] <= 20) dp[level][num + numbers[level]] += dp[level - 1][num];
				if (num - numbers[level] >= 0)  dp[level][num - numbers[level]] += dp[level - 1][num];
			}
		}
		System.out.println(dp[N - 2][numbers[N - 1]]);
	}
}
