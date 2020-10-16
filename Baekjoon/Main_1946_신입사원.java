import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1946_신입사원 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] scores = new int[N][2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				scores[i][0] = Integer.parseInt(st.nextToken());
				scores[i][1] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(scores, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[0], o2[0]);
				}
			});

			int pass = 1;
			int min = scores[0][1]; // 첫번째 과목 등수가 나보다 높은 애들 중 가장 높은 두번째 과목 등수
			for (int i = 1; i < N; i++) {
				if (scores[i][1] < min) {
					min = scores[i][1];
					pass++;
				}
			}
			sb.append(pass).append("\n");
		}
		System.out.println(sb.toString());
	}
}
