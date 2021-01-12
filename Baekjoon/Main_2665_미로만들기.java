import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main_2665_미로만들기 {
    static int N;
    static boolean[][] map;
    static int[][] change;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        change = new int[N][N];
        String line;

        for (int i = 0; i < N; i++) {
            Arrays.fill(change[i], Integer.MAX_VALUE);
            line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) == '1' ? true : false;
            }
        }

        bfs(0, 0);
        System.out.println(change[N - 1][N - 1]);
    }

    private static void bfs(int r, int c) {
        LinkedList<int[]> queue = new LinkedList<>();
        change[r][c] = 0;
        queue.offer(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            r = tmp[0];
            c = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                // 범위 안이고, 현재 위치가 다음 위치보다 방을 바꾼 횟수가 적으
                if (isIn(nr, nc) && change[r][c] < change[nr][nc]) {
                    if (map[nr][nc]) change[nr][nc] = change[r][c];
                    else change[nr][nc] = change[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }

    private static boolean isIn(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < N;
    }
}
