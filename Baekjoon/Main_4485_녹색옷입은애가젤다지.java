import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {
    static int N;
    static int[][] map, cost;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 0;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
                    map = new int[N][N];
                    cost = new int[N][N];

                    StringTokenizer st;
                    for (int i = 0; i < N; i++) {
                        st = new StringTokenizer(br.readLine());
                        for (int j = 0; j < N; j++) {
                            map[i][j] = Integer.parseInt(st.nextToken());
                            cost[i][j] = Integer.MAX_VALUE;
                }
            }
            sb.append("Problem ").append(++T).append(": ").append(dijkstra(0, 0)).append("\n");
        }
        System.out.println(sb);
    }

    private static int dijkstra(int r, int c) {
        LinkedList<int[]> queue = new LinkedList<>();
        cost[r][c] = map[r][c];
        queue.offer(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            r = tmp[0];
            c = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if (!isIn(nr, nc) || map[nr][nc] + cost[r][c] >= cost[nr][nc]) continue;
                cost[nr][nc] = map[nr][nc] + cost[r][c];
                queue.offer(new int[]{nr, nc});
            }
        }
        return cost[N - 1][N - 1];
    }

    private static boolean isIn(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < N;
    }
}
