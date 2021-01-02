import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11000_강의실배정 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] classes = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            classes[i][0] = Integer.parseInt(st.nextToken());
            classes[i][1] = Integer.parseInt(st.nextToken());
        }

        // 시작 시간을 기준으로 정렬, 같으면 종료 시간을 기준으로 정렬
        Arrays.sort(classes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                else return Integer.compare(o1[0], o2[0]);
            }
        });

        Queue<Integer> pq_end = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int start = classes[i][0];
            int end = classes[i][1];

            // 의문 : 종료 시간이 같은 수업이 있으면 둘 다 삭제 해야하는게 아닌지?
            //     ==> 종료 시간이 곂치지 않는다는 가정이 존재하나?
            if (!pq_end.isEmpty() && pq_end.peek() <= start) {
                pq_end.poll();
            }
            pq_end.offer(end);
        }
        System.out.println(pq_end.size());
    }
}
