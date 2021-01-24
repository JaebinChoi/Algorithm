import java.util.Scanner;

public class Main_11057_오르막수 {
    static final int M = 10007;
    static final int NUM = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] dp = new int[N + 1][NUM];

        for (int i = 0; i < NUM; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < NUM; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k] % M;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < NUM; i++) {
            sum += dp[N][i];
        }

        System.out.println(sum % M);
    }
}
