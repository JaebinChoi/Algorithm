import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14621_나만안되는연애 {
    static int[] parent, rank;
    static boolean[] gender;

    static void makeSet(int x) {
        parent[x] = x;
    }

    static int findSet(int x) {
        if (parent[x] == x) return x;
        return findSet(parent[x]);
    }

    static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        if (rank[px] < rank[px]) parent[px] = py;
        else {
            parent[py] = px;
            if (rank[px] == rank[px]) ++rank[px];
        }
    }

    static int N, M;
    static Queue<Connect> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        rank = new int[N + 1];
        gender = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            makeSet(i);
            gender[i] = st.nextToken().equals("M");
        }

        pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Connect(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        System.out.println(getMinimumSpaningTree());
    }

    // 최소 스패닝 트리 구하는 메소
    private static int getMinimumSpaningTree() {
        int cnt = 0;
        int sum_cost = 0;

        while (!pq.isEmpty()) {
            Connect con = pq.poll();
            int px = findSet(con.x);
            int py = findSet(con.y);

            if (cnt == N - 1) break;
            if (isSameGender(con.x, con.y) || px == py) continue; // 성이 같거나 부모가 같으면 패스

            union(con.x, con.y);
            sum_cost += con.cost;
            ++cnt;
        }
        return cnt == N - 1 ? sum_cost : -1;
    }

    // 성이 같으면 true, 다르면 false
    private static boolean isSameGender(int x, int y) {
        return gender[x] == gender[y];
    }

    static class Connect implements Comparable<Connect> {
        int x, y, cost;

        public Connect(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Connect o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
