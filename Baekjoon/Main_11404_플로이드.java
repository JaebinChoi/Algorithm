import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11404_플로이드 {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static int[][] city;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        city = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) city[i][j] = 0;
                else city[i][j] = INF;
            }
        }

        int from, to, cost;
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            city[from][to] = Math.min(cost, city[from][to]);
        }

        floyd_warshall();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(city[i][j] == INF ? 0 : city[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void floyd_warshall() {
        for (int k = 1; k <= N; k++) { // 경유지
            for (int i = 1; i <= N; i++) { // 출발지
                if (i == k) continue;
                for (int j = 1; j <= N; j++) { // 도착지
                    if (j == k || j == i) continue;

                    if (city[i][k] != INF && city[k][j] != INF // 갈 수 있는 곳
                            && city[i][k] + city[k][j] < city[i][j]) { // 경유지 들르는게 바로 가는거 보다 빠르
                        city[i][j] = city[i][k] + city[k][j];
                    }
                }
            }
        }
    }
}
