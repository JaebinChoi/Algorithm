import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1238_파티 {
    static int N, M, S;

    static class Edge implements Comparable<Edge> {
        int v, cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        LinkedList<Edge>[] list = new LinkedList[N + 1];
        LinkedList<Edge>[] list_reverse = new LinkedList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new LinkedList<>();
            list_reverse[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].offer(new Edge(to, cost));
            list_reverse[to].offer(new Edge(from, cost));
        }

        int[] cost = djikstra(list);
        int[] cost_reverse = djikstra(list_reverse);

        System.out.println(find_latest_time(cost, cost_reverse));
    }

    private static int find_latest_time(int[] cost, int[] cost_reverse) {
        int time = 0;
        for (int i = 1; i <= N; i++) {
            time = Math.max(time, cost[i] + cost_reverse[i]);
        }
        return time;
    }

    private static int[] djikstra(LinkedList<Edge>[] list) {
        Queue<Edge> pq = new PriorityQueue<>();
        int[] cost = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (i == S) cost[i] = 0;
            else cost[i] = Integer.MAX_VALUE;
        }
        pq.offer(new Edge(S, cost[S]));

        boolean[] check = new boolean[N + 1];
        while (!pq.isEmpty()) {
            Edge node = pq.poll();

            if (node.cost == Integer.MAX_VALUE) continue;
            for (Edge next : list[node.v]) {
                if (!check[next.v] && cost[node.v] + next.cost < cost[next.v]) {
                    cost[next.v] = cost[node.v] + next.cost;
                    pq.offer(new Edge(next.v, cost[next.v]));
                }
            }
            check[node.v] = true;
        }
        return cost;
    }
}
