import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Solution_1949_등산로조성 {
    static int N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static int result;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
 
            ArrayList<int[]> list = new ArrayList<>();
            int max = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
 
                    if (map[i][j] > max) {
                        list.clear();
                        max = map[i][j];
                        list.add(new int[] { i, j });
                    } else if (map[i][j] == max)
                        list.add(new int[] { i, j });
                }
            }
 
            result = Integer.MIN_VALUE;
            for (int i = 0, size = list.size(); i < size; i++) {
                visited = new boolean[N][N];
                dfs(list.get(i)[0], list.get(i)[1], 1, true);
            }
 
            System.out.println("#" + tc + " " + result);
        } // testcase
    } // main
 
    private static void dfs(int r, int c, int cnt, boolean isAble) {
    	visited[r][c] = true;
    	
        for (int i = 0; i < 4; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
 
            // 범위 이탈 또는 방문
            if (!isIn(nr, nc) || visited[nr][nc]) {
                result = cnt > result ? cnt : result;
                continue;
            }
             
            if (map[nr][nc] < map[r][c]) { // 내리막길
                dfs(nr, nc, cnt + 1, isAble);
            } else { // 오르막길
                if (isAble && map[nr][nc] - K < map[r][c]) { // 공사 가능
                	int tmp = map[nr][nc];
                    map[nr][nc] = map[r][c] - 1;
                    dfs(nr, nc, cnt + 1, false);
                    map[nr][nc] = tmp;
                } else { // 공사 불가능
                    result = cnt > result ? cnt : result;
                }
            }
        }
        visited[r][c] = false;
    }
 
    private static boolean isIn(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < N;
    }
} // class