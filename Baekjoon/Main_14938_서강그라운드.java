import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_14938_서강그라운드 {
    static int N, M, R, total_item;
    static int[] items, costs;
    static boolean[] visited;
    static ArrayList<Edge>[] list;
    static Queue<Edge> pq;

    static class Edge implements Comparable<Edge> {
        int v, value;

        public Edge(int v, int value) {
            this.v = v;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.value, o.value);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        items = new int[N + 1];
        costs = new int[N + 1];
        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, cost));
            list[v].add(new Edge(u, cost));
        }

        for (int i = 1; i <= N; i++) {
            Arrays.fill(costs, Integer.MAX_VALUE);
            djikstra(i);
            total_item = Math.max(total_item, get_total_item());
            Arrays.fill(visited, false);
        }
        System.out.println(total_item);
    }

    private static int get_total_item() {
        int total = 0;
        for (int i = 1; i <= N; i++) {
            if (costs[i] <= M) {
                total += items[i];
            }
        }
        return total;
    }

    private static void djikstra(int v) {
        costs[v] = 0;
        pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.v]) continue;
            visited[cur.v] = true;

            for (int i = 0, size = list[cur.v].size(); i < size; i++) {
                Edge next = list[cur.v].get(i);
                if (costs[cur.v] + next.value < costs[next.v]) {
                    costs[next.v] = costs[cur.v] + next.value;
                    pq.offer(new Edge(next.v, costs[next.v]));
                }
            }
        }
    }
}
