import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1956_운동 {
    static final int INF = 10001;
    static int N, M;
    static int[][] road;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        road = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(road[i], INF);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            road[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        floyd_warshall();

        int road_length = INF;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j || road[i][j] == INF || road[j][i] == INF) continue;
                road_length = Math.min(road_length, road[i][j] + road[j][i]);
            }
        }
        System.out.println(road_length == INF ? -1 : road_length);
    }

    private static void floyd_warshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (k == i) continue;
                for (int j = 1; j <= N; j++) {
                    if (j == k || j == i) continue;
                    if (road[i][k] + road[k][j] < road[i][j]) road[i][j] = road[i][k] + road[k][j];
                }
            }
        }
    }
}
