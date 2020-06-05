import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1966_프린터큐 {
	static int N, M;
	static LinkedList<int[]> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			list = new LinkedList<>();

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				list.offer(new int[] { i, Integer.parseInt(st.nextToken()) });

			int result = 0;
			while (true) {
				int[] n = list.poll();
				boolean flag = true;
				
				for (int i = 0, size = list.size(); i < size; i++) {
					if (n[1] < list.get(i)[1]) {
						list.offer(n);
						flag = false;
						break;
					}
				}
				if(flag) {
					result++;
					if(n[0] == M) break;
				}
			}
			System.out.println(result);
		}
	}
}
