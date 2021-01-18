import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10423_전기가부족해 {
    static int[] parent, rank;

    static void makeSet(int x) {
        parent[x] = x;
    }

    static int findSet(int x) {
        if (parent[x] == -1) return -1; // 발전소에 연결된 경우
        if (parent[x] == x) return x;   // 발전소에 연결되지 않은 경우
        return findSet(parent[x]);
    }

    static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        if (px == -1 && py == -1) return;               // 둘 다 발전소에 연결된 경우
        else if (px == -1) parent[py] = px;             // 하나만 발전소에 연결된 경우
        else if (py == -1) parent[px] = py;
        else {                                          // 둘 다 발전소에 연결되우지 않은 경
            if (rank[px] < rank[py]) parent[px] = py;
            else {
                parent[py] = px;
                if (rank[px] == rank[py]) ++rank[px];
            }
        }
    }

    static class Cable implements Comparable<Cable> {
        int x, y, value;

        public Cable(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Cable o) {
            return Integer.compare(this.value, o.value);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            makeSet(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            parent[Integer.parseInt(st.nextToken())] = -1;  // 발전소 = -1
        }

        Queue<Cable> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Cable(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int cable_cost = 0;
        while (!pq.isEmpty()) {
            Cable cable = pq.poll();
            int px = findSet(cable.x);
            int py = findSet(cable.y);

            if (px == py) continue;
            union(cable.x, cable.y);
            cable_cost += cable.value;
            if (is_all_connect()) break;
        }
        System.out.println(cable_cost);
    }

    // 모든 도시가 발전소에 연결되어 있는지 확인하는 메소드
    private static boolean is_all_connect() {
        for (int i = 1, len = parent.length; i < len; i++) {
            if (findSet(i) != -1)
                return false; // parent[i]가 아닌 findSet(i)로 해야함 => 도시끼리 연결했다가 발전소로 연결되면 parent[i] = -1이 아닌 인덱스가 나옴
        }
        return true;
    }
}
