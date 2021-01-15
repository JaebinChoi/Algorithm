import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2458_키순서 {
    static int N, M;
    static boolean[][] big, small;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        big = new boolean[N + 1][N + 1];
        small = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            big[b][s] = true;
            small[s][b] = true;
        }

        floyd_warshall();
        boolean[][] merge = merge();
        System.out.println(count_student(merge));
    }

    private static int count_student(boolean[][] merge) {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            boolean flag = true;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (!merge[i][j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) ++cnt;
        }
        return cnt;
    }

    private static boolean[][] merge() {
        boolean[][] arr = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                arr[i][j] = big[i][j] | small[i][j];
            }
        }
        return arr;
    }

    private static void floyd_warshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (k == i) continue;
                for (int j = 1; j <= N; j++) {
                    if (j == k || j == i) continue;

                    if (big[i][k] && big[k][j]) big[i][j] = true;
                    if (small[i][k] && small[k][j]) small[i][j] = true;
                }
            }
        }
    }
}
