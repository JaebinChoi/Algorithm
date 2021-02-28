import java.io.*;
import java.util.StringTokenizer;

class Main_지뢰찾기 {
    static int N, M;
    static char[][] map;
    static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        // 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 2차원 배열을 순회하면서 주변의 지뢰 개수를 확인한다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '*') continue;
                map[i][j] = (char) (round_search(i, j) + '0');
            }
        }

        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    // 8 방향을 체크해서 지뢰의 개수를 반환하는 메소드
    private static int round_search(int r, int c) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if (!isIn(nr, nc)) continue;
            if (map[nr][nc] == '*') ++cnt;
        }
        return cnt;
    }

    // 범위 체크
    private static boolean isIn(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < M;
    }
}