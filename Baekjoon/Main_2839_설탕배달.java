import java.util.Scanner;

public class Main_2839_설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] memo = new int[N + 1];

		// 3kg
		for (int i = 0; i <= N; i++) {
			if (i % 3 == 0) memo[i] = i / 3;
			else memo[i] = Integer.MAX_VALUE - 1; // overflow 방지

		}

		// 5kg
		for (int i = 5; i <= N; i++) {
			if (memo[i] > memo[i - 5] + 1)
				memo[i] = memo[i - 5] + 1;
		}
		
		System.out.println(memo[N] == Integer.MAX_VALUE - 1 ? -1 : memo[N]);
	}
}
