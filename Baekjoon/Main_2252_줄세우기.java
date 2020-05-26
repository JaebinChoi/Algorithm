import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/** 위상정렬 */
public class Main_2252_줄세우기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();

		int[] degree = new int[N + 1]; // 진입차수
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to); // 키작은애 list에 키 큰애 넣기 (연결)
			degree[to]++; 		// 키큰애 연결된 개수를 더해줌
		}

		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			if (degree[i] == 0) // 키 작은애
				queue.offer(i);

		int[] result = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if (queue.isEmpty()) break; // 사이클 발생

			int from = queue.poll();
			result[i] = from;

			for (int j = 0, size = list[from].size(); j < size; j++) {
				int to = list[from].get(j);
				if (--degree[to] == 0) // 연결된 node 끊기
					queue.offer(to);
			}
		}

		for (int i = 1; i <= N; i++)
			System.out.print(result[i] + " ");
	}
}
