import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10159_저울 {
    static int N, M;
    static boolean[][] heavy, light;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        heavy = new boolean[N + 1][N + 1];
        light = new boolean[N + 1][N + 1];

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            heavy[t1][t2] = true;
            light[t2][t1] = true;
        }

        floyd_warshall(heavy); // 각 물건보다 가벼운 물건만 표시
        floyd_warshall(light); // 각 물건보다 무거운 물건만 표시
        boolean[][] merge = merge(heavy, light);

        System.out.println(getCount(merge));
    }

    // 비교 불가능한 물건의 개수를 구하는 메소
    private static String getCount(boolean[][] arr) {
        StringBuilder sb = new StringBuilder();
        int cnt;
        for (int i = 1; i <= N; i++) {
            cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (!arr[i][j]) ++cnt;
            }
            sb.append(cnt).append("\n");
        }
        return sb.toString();
    }

    // 두 배열을 OR 연산하는 메소
    private static boolean[][] merge(boolean[][] arr1, boolean[][] arr2) {
        boolean[][] arr_merge = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr_merge[i][j] = arr1[i][j] | arr2[i][j];
            }
        }
        return arr_merge;
    }

    // 플로이드 와샬 메소
    private static void floyd_warshall(boolean[][] arr) {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (k == i) continue;
                for (int j = 1; j <= N; j++) {
                    if (j == k || j == i) continue;

                    if (arr[i][k] && arr[k][j]) {
                        arr[i][j] = true;
                    }
                }
            }
        }
    }
}
