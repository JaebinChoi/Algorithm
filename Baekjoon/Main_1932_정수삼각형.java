package staging;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] tri = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0, size = st.countTokens(); j < size; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[n][n];
		dp[0][0] = tri[0][0];
		
		for(int i = 1; i < n; i++) {
			// 첫번째 수는 비교할 필요없이 이전 줄의 첫번째 값이랑 더하면됨
			dp[i][0] = dp[i-1][0] + tri[i][0];
			
			// 이전 줄 값 2개랑 비교
			for(int j = 1; j < i; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + tri[i][j];
			}
			// 마지막 수는 비교할 필요없이 이전 줄의 마지막 값이랑 더하면됨
			dp[i][i] = dp[i-1][i-1] + tri[i][i];
		}
		
		Arrays.sort(dp[n-1]);
		System.out.println(dp[n-1][n-1]);
	}
}
