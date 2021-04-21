import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설 {
    static int N, X; // 맵 크기, 활주로 길이
    static int[][] map1, map2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map1 = new int[N][N];
            map2 = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map1[i][j] = Integer.parseInt(st.nextToken());
                    map2[j][i] = map1[i][j];
                }
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                if (isConstruct(map1, i)) ++result;  // 행 단위 순회
                if (isConstruct(map2, i)) ++result;  // 열 단위
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    private static boolean isConstruct(int[][] map, int idx) {
        int len = 1;                // 현재 활주로 길이
        int height = map[idx][0];   // 현재 높이

        for (int n = 1; n < N; n++) {
            int next = map[idx][n]; // 다음 지형의 높이

            // 지형의 높이가 2 이상 차이날 경우, 경사로를 건설할 수 없다.
            if (Math.abs(height - next) > 1) return false;

            // 높이가 같은 경우, 활주로 길이 + 1
            if (height == next) ++len;

            // 높이가 높은 경우
            else if (height < next) {
                if (len < X) return false;  // 활주로 길이가 짧으면, 건설할 수 없다.
                len = 1;                    // 건설하면, 길이와 높이 초기화
                height = next;
            }

            // 높이가 낮은 경우
            else if (height > next) {
                if (N - n < X) return false; // 남은 활주로 길이가 짧아서, 건설할 수 없는 경우

                for (int j = 1; j < X; j++) {
                    if (height - 1 != map[idx][++n]) return false; // 활주로 길이만큼, 다음 지형의 높이가 현재 높이 - 1이 아닌 경우
                }

                // 건설하면, 길이와 높이 초기화
                len = 0;
                height = next;
            }
        }
        return true;
    }
}
