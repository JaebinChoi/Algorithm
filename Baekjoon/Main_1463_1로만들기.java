package staging;
import java.io.InputStreamReader;

import java.io.BufferedReader;

public class Main_1463_1로만들기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];

		num[1] = 0;

		for (int i = 2; i <= N; i++) {
			int tmp = Integer.MAX_VALUE;

			if (i % 3 == 0)
				tmp = tmp < (num[i / 3] + 1) ? tmp : (num[i / 3] + 1);

			if (i % 2 == 0)
				tmp = tmp < (num[i / 2] + 1) ? tmp : (num[i / 2] + 1);

			tmp = tmp < (num[i - 1] + 1) ? tmp : (num[i - 1] + 1);

			num[i] = tmp;
		}

		System.out.println(num[N]);

	}
}
