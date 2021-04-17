import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5653_줄기세포배양 {
    static int N, M, K;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] map;
    static PriorityQueue<Cell> queue;

    static class Cell implements Comparable<Cell> {
        int r, c;
        int lifeTime, curTime; // 생명력, 현재 생명력
        boolean isLive; // true : 활성 상태, false : 비활성 상태

        public Cell(int r, int c, int lifeTime, int curTime, boolean isLive) {
            this.r = r;
            this.c = c;
            this.lifeTime = lifeTime;
            this.curTime = curTime;
            this.isLive = isLive;
        }

        @Override
        public int compareTo(Cell o) {
            return -1 * Integer.compare(this.lifeTime, o.lifeTime);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[K * 2 + N][K * 2 + M];
            queue = new PriorityQueue<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    int lifeTime = Integer.parseInt(st.nextToken());
                    if (lifeTime == 0) continue; // 번식되지 않은 공간
                    map[K + i][K + j] = lifeTime; // 번식된 생명력 저장
                    queue.offer(new Cell(K + i, K + j, lifeTime, 0, false));
                }
            }

            for (int i = 0; i < K; i++) {
                bfs();
            }

            System.out.println("#" + tc + " " + queue.size());
        }
    }

    private static void bfs() {
        Queue<Cell> tmp = new PriorityQueue<>();

        for (int t = 0, size = queue.size(); t < size; t++) {
            Cell cell = queue.poll();
            int nextTime = cell.curTime + 1;

            // 활성 상태 + 번식 시기
            if (cell.isLive && cell.curTime == 0) {
                for (int i = 0; i < 4; i++) {
                    int nr = cell.r + dir[i][0];
                    int nc = cell.c + dir[i][1];

                    // 이미 번식된 곳
                    if (map[nr][nc] != 0) continue;

                    map[nr][nc] = cell.lifeTime; // 번식
                    tmp.offer(new Cell(nr, nc, cell.lifeTime, 0, false));
                }
            }

            // 현재 세포 상태 변경
            if (nextTime == cell.lifeTime) {
                // 비활성화 => 활성화
                if (!cell.isLive) tmp.offer(new Cell(cell.r, cell.c, cell.lifeTime, 0, true));
            } else tmp.offer(new Cell(cell.r, cell.c, cell.lifeTime, nextTime, cell.isLive)); // 시간만 흐를 경우
        }

        // 변경 사항 적용
        queue.addAll(tmp);
    }
}
