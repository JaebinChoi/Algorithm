import java.util.Scanner;

public class Main_10884_쉬운계단수 {
    static final long M = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] dp = new long[N + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][j + 1] % M;
                else if (j == 9) dp[i][j] = dp[i - 1][j - 1] % M;
                else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1] % M;
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
        }

        System.out.println(result % M);
    }
}
