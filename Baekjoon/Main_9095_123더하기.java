package staging;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9095_123더하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] num = new int[20];

			num[1] = 1;
			num[2] = 2;
			num[3] = 4;
			num[4] = 7;

			for (int i = 5; i <= n; i++)
				num[i] = num[i - 1] + num[i - 2] + num[i - 3];

			System.out.println(num[n]);
		}
	}
}
