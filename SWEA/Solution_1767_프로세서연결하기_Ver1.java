import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기_Ver1 {
    static int N, resultWireLength, resultCoreCnt; // 배열 크기, 전선 총 길이, 코어 개수
    static int[][] processor;
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

            connect(0, 0, 0);

            System.out.println("#" + tc + " " + resultWireLength);
        }
    }

    private static void connect(int cur, int totalCoreCnt, int totalWireLength) {
        if (cur == cores.size()) { // 코어 다 돌았을 경우
            if (totalCoreCnt > resultCoreCnt) { // 코어 개수가 더 많을 경우
                resultCoreCnt = totalCoreCnt;
                resultWireLength = totalWireLength;
            } else if (totalCoreCnt == resultCoreCnt) { // 코어 개수는 같지만
                if (totalWireLength < resultWireLength) { // 전선의 총 길이가 짧을 경우
                    resultWireLength = totalWireLength;
                }
            }
            return;
        }

        Core core = cores.get(cur);
        for (int d = 0; d < 4; d++) { // 사방 탐색
            int nr = core.r;
            int nc = core.c;
            int length = 0;

            while (true) { // 직진
                nr += dir[d][0];
                nc += dir[d][1];

                // 벽을 만날 때까지
                if (!isIn(nr, nc)) break;

                // 코어를 만나면
                if (processor[nr][nc] == 1) {
                    length = 0;
                    break;
                }

                ++length;
            }

            nr = core.r;
            nc = core.c;
            // 전선을 1로 채워줌
            for (int i = 0; i < length; i++) {
                nr += dir[d][0];
                nc += dir[d][1];
                processor[nr][nc] = 1;
            }

            // 전선과 연결이 불가능 => 다음 코어로
            if (length == 0) {
                connect(cur + 1, totalCoreCnt, totalWireLength);
            }
            // 전선과 연결이 가능
            else {
                connect(cur + 1, totalCoreCnt + 1, totalWireLength + length);
            }

            // 전선 원상복구
            nr = core.r;
            nc = core.c;
            for (int i = 0; i < length; i++) {
                nr += dir[d][0];
                nc += dir[d][1];
                processor[nr][nc] = 0;
            }
        }
    }

    private static boolean isIn(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < N;
    }

    private static boolean isEdge(int r, int c) {
        return r == 0 || c == 0 || r == N - 1 || c == N - 1;
    }

}
