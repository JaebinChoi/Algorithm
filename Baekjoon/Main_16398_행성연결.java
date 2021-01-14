import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16398_행성연결 {
    static int[] parent, rank;

    static void makeSet(int x) {
        parent[x] = x;
    }

    static int findSet(int x) {
        if (x == parent[x]) {
            return x;
        }

        parent[x] = findSet(parent[x]);
        return parent[x];
    }

    static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[py] = px;
            if (rank[px] == rank[py]) {
                ++rank[px];
            }
        }
    }

    static class Planet implements Comparable<Planet> {
        int u, v, cost;

        public Planet(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Planet o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] planet = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                planet[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Planet> pq = new PriorityQueue<>();
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                pq.offer(new Planet(i, j, planet[i][j]));
            }
        }

        parent = new int[N];
        rank = new int[N];

        for (int i = 0; i < N; i++) {
            makeSet(i);
        }

        int cnt = 0;
        long cost = 0;
        while (cnt < N - 1) {
            Planet p = pq.poll();
            int pu = findSet(p.u);
            int pv = findSet(p.v);

            if (pu == pv) continue;
            union(pu, pv);
            ++cnt;
            cost += p.cost;
        }
        System.out.println(cost);
    }
}
