import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1927_최소힙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            if (num == 0) {
                if (queue.isEmpty()) sb.append(0).append("\n");
                else sb.append(queue.poll()).append("\n");
            } else queue.offer(num);
        }

        System.out.println(sb.toString());
    }
}
