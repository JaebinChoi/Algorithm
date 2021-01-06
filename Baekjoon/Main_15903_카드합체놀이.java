import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15903_카드합체놀이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        Queue<Long> queue = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return Long.compare(o1, o2);
            }
        });

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            queue.offer(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < T; i++) {
            long u = queue.poll();
            long v = queue.poll();
            queue.offer(u + v);
            queue.offer(u + v);
        }

        long sum_card = 0;
        for (long card : queue) {
            sum_card += card;
        }

        System.out.println(sum_card);
    }
}
