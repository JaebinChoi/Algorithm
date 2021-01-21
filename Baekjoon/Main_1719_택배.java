import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1719_택배 {
    static final int INF = 10001;
    static int N, M;
    static int[] cost, path;
    static boolean[] visited;
    static ArrayList<int[]>[] list;
    static StringBuilder sb;
    static Queue<int[]> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cost = new int[N + 1];
        path = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[u].add(new int[]{v, cost});
            list[v].add(new int[]{u, cost});
        }

        pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            Arrays.fill(cost, INF);
            djikstra(i);
            Arrays.fill(visited, false);
            Arrays.fill(path, 0);
            pq.clear();
        }

        System.out.println(sb.toString());
    }

    private static void djikstra(int v) {
        cost[v] = 0;
        pq.offer(new int[]{v, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]]) continue;

            visited[cur[0]] = true;
            for (int i = 0, size = list[cur[0]].size(); i < size; i++) {
                int[] next = list[cur[0]].get(i);
                if (cost[cur[0]] + next[1] < cost[next[0]]) {
                    cost[next[0]] = cost[cur[0]] + next[1];
                    pq.offer(new int[]{next[0], cost[next[0]]});
                    path[next[0]] = cur[0];
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (i == v) sb.append("-").append(" ");
            else sb.append(find_next(i, v)).append(" ");
        }
        sb.append("\n");
    }

    private static int find_next(int v, int start) {
        if (path[v] == start) return v;
        return find_next(path[v], start);
    }
}
