import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2071_평균값구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			double sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int size = st.countTokens();
			for (int i = 0; i < size; i++)
				sum += Integer.parseInt(st.nextToken());
			sum /= size;

			System.out.printf("#%d %.0f\n", tc, sum);
		}
	}
}
