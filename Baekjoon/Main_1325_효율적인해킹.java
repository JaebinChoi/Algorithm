import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1325_효율적인해킹 {
    static ArrayList<Integer>[] computer;
    static boolean[] visited;
    static int[] count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        count = new int[N + 1];

        computer = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            computer[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            computer[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            dfs(i);
            Arrays.fill(visited, false);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, count[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (count[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        for (int i = 0, size = computer[cur].size(); i < size; i++) {
            int next = computer[cur].get(i);
            if (visited[next]) continue;
            count[next]++;
            dfs(next);
        }
    }
}
