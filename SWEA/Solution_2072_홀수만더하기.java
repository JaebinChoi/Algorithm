import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2072_홀수만더하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int size = st.countTokens();
			for (int i = 0; i < size; i++) {
				int num = Integer.parseInt(st.nextToken());
				if (num % 2 == 1) {
					sum += num;
				}
			}

			System.out.println("#" + tc + " " + sum);
		}
	}
}
