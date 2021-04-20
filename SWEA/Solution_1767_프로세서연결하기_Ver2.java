import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기_Ver2 {
    static int N, totalWire, totalCore, resultWireLength, resultCoreCnt;
    static int[][] processor, map;
    static ArrayList<Core> cores;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Core {
        int r, c;

        public Core(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            processor = new int[N][N];
            cores = new ArrayList<>();
            map = new int[N][N];
            resultWireLength = 0;
            resultCoreCnt = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    processor[i][j] = Integer.parseInt(st.nextToken());

                    // 모서리 아니고, Core 일 경우
                    if (!isEdge(i, j) && processor[i][j] == 1) {
                        cores.add(new Core(i, j));
                    }
                }
            }

            connect(0);
            System.out.println("#" + tc + " " + resultWireLength);
        }
    }

    private static void connect(int cur) {
        if (cur == cores.size()) {                      // 코어 다 돌았을 경우
            if (totalCore > resultCoreCnt) {            // 코어 개수가 더 많을 경우
                resultCoreCnt = totalCore;
                resultWireLength = totalWire;
            } else if (totalCore == resultCoreCnt) {    // 코어 개수는 같지만
                if (totalWire < resultWireLength) {     // 전선의 총 길이가 짧을 경우
                    resultWireLength = totalWire;
                }
            }
            return;
        }

        Core core = cores.get(cur);                     // 코어 하나씩 순회
        for (int d = 0; d < 4; d++) {                   // 사방 탐색
            int wireLength = extend(core, d, 0);   // 직선으로 전선 확장
            connect(cur + 1);                       // BFS
            clean(core, d, wireLength);                 // 확장 전선 원상 복구
        }
    }

    private static void clean(Core core, int d, int wireLength) {
        int nr = core.r;
        int nc = core.c;
        int tmpWireLength = 0;

        for (int i = 0; i < wireLength; i++) {                  // 직진
            nr += dir[d][0];
            nc += dir[d][1];

            ++tmpWireLength;                                    // 원상 복구 길이

            map[nr][nc] = 0;                                    // 원상복구
        }

        if (!isIn(nr + dir[d][0], nc + dir[d][1])) {    // 전선 확장할 때 끝이 모서리였다면
            --totalCore;                                        // 코어 개수 하나 빼줌
            totalWire -= tmpWireLength;                         // 총 전선 길이에 확장했던 전선 길이를 빼줌
        }
    }

    private static int extend(Core core, int d, int wire) {
        int nr = core.r;
        int nc = core.c;


        while (true) {                  // 직진
            nr += dir[d][0];
            nc += dir[d][1];

            if (!isIn(nr, nc)) {        // 모서리(전원 연결)를 만났을 경우
                totalWire += wire;      // 총 전선 = 길이에 확장한 전선 길이를 더해줌
                ++totalCore;            // 코어 개수를 더해줌
                return wire;
            }

            if (map[nr][nc] >= 1) {     // 코어 또는 전선을 만났을 경우
                return wire;            // 처음 길이 반환
            }

            ++wire;                     // 전선 길이 + 1
            map[nr][nc] = 2;            // 전선
        }
    }

    private static boolean isIn(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < N;
    }

    private static boolean isEdge(int r, int c) {
        return r == 0 || r == N - 1 || c == 0 || c == N - 1;
    }
}
