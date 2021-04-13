import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_10966_물놀이를가자 {
    static int N, M;
    static int[][] distance;
    static LinkedList<int[]> water;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            // 초기화 코드
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            distance = new int[N][M];
            water = new LinkedList<>();

            // 물까지의 거리를 저장하는 배열
            for (int i = 0; i < N; i++) {
                Arrays.fill(distance[i], -1);
            }

            // 2차원 배열 입력 => 물이면 거리 = 0
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    if (line.charAt(j) == 'W') {
                        distance[i][j] = 0;
                        water.add(new int[]{i, j});
                    }
                }
            }

            // 물을 기준으로 BFS
            goIntoWater();

            // 모든 이동 횟수의 합 계산
            int totalCost = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    totalCost += distance[i][j];
                }
            }

            sb.append("#").append(tc).append(" ").append(totalCost).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void goIntoWater() {
        // 물인 곳을 단계별로 순회하기 때문에 처음 만난 땅은 무조건 최소 이동 횟수
        while (!water.isEmpty()) {
            int[] tmp = water.poll();
            int r = tmp[0];
            int c = tmp[1];

            // 사방 탐색
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                // 1.범위를 벗어나거나
                // 2.최소 이동 횟수를 찾은 곳 or 물 => Pass
                if (!isIn(nr, nc) || distance[nr][nc] > -1) continue;

                // 최소 이동 횟수 적용
                distance[nr][nc] = distance[r][c] + 1;
                water.offer(new int[]{nr, nc});
            }
        }
    }

    private static boolean isIn(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < M;
    }
}
