import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5650_핀볼게임 {
    static int N, resultScore;
    static int[][] map, wormHole;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Ball {
        int r, c, d;

        public Ball(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            wormHole = new int[11][4];
            resultScore = 0;

            // 웜홀 초기화
            for (int i = 6; i < 11; i++) {
                Arrays.fill(wormHole[i], -1);
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (map[i][j] > 5) {                        // 웜홀
                        if (wormHole[map[i][j]][0] == -1) {     // 첫 번째 웜홀
                            wormHole[map[i][j]][0] = i;
                            wormHole[map[i][j]][1] = j;
                        } else {                                // 두 번째 웜홀
                            wormHole[map[i][j]][2] = i;
                            wormHole[map[i][j]][3] = j;
                        }
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) {               // 빈 칸
                        for (int k = 0; k < 4; k++) {   // 사방 탐색
                            resultScore = Math.max(resultScore, move(new Ball(i, j, k)));
                        }

                    }
                }
            }

            System.out.println("#" + tc + " " + resultScore);
        }
    }

    private static int move(Ball ball) {
        int score = 0;
        int nr = ball.r;
        int nc = ball.c;
        int d = ball.d;

        while (true) {
            nr = nr + dir[d][0];
            nc = nc + dir[d][1];

            // 가장자리에 부딪히는 경우, 점수 + 1, 방향 전환
            if (!isIn(nr, nc)) {
                ++score;
                if (d == 0 || d == 2) ++d;
                else --d;
                continue;
            }

            int type = map[nr][nc];

            // 블랙홀을 만나거나, 제자리로 돌아온 경우
            if (type == -1 || (nr == ball.r && nc == ball.c)) {
                return score;
            }

            if (type == 0) continue;    // 빈 칸인 경우
            else if (type > 5) {        // 웜홀을 만난 경우
                if (wormHole[type][0] == nr && wormHole[type][1] == nc) {
                    nr = wormHole[type][2];
                    nc = wormHole[type][3];
                } else {
                    nr = wormHole[type][0];
                    nc = wormHole[type][1];
                }
            } else {                    // 블록을 만난 경우
                ++score;
                if ((type == 1 && d == 2) || (type == 2 && d == 1) || (type == 3 && d == 1) || (type == 4 && d == 3) || (type == 5 && d == 1)) d = 0; // 상 방향으로 전환하는 경우
                else if ((type == 1 && d == 0) || (type == 2 && d == 2) || (type == 3 && d == 3) || (type == 4 && d == 0) || (type == 5 && d == 0)) d = 1; // 하 방향으로 전환하는 경우
                else if ((type == 1 && d == 3) || (type == 2 && d == 3) || (type == 3 && d == 0) || (type == 4 && d == 1) || (type == 5 && d == 3)) d = 2; // 좌 방향으로 전환하는 경우
                else if ((type == 1 && d == 1) || (type == 2 && d == 0) || (type == 3 && d == 2) || (type == 4 && d == 2) || (type == 5 && d == 2)) d = 3; // 우 방향으로 전환하는 경우
            }
        }
    }

    private static boolean isIn(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < N;
    }
}
