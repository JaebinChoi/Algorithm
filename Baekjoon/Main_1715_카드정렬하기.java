import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_1715_카드정렬하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int time = 0;
        while (pq.size() > 1) {
            int sum = pq.poll() + pq.poll();
            time += sum;
            pq.offer(sum);
        }

        System.out.println(time);
    }
}
