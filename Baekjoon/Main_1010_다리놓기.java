import java.util.Scanner;

public class Main_1010_다리놓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int R = sc.nextInt();
			int N = sc.nextInt();

			int[] permutation = new int[N + 1];
			permutation[1] = N;

			if (R == 1) {
				System.out.println(N);
				continue;
			}

			for (int i = 2; i <= R; i++) {
				permutation[i] = permutation[i - 1] * (N + 1 - i) / i;
			}

			System.out.println(permutation[R]);
		}
	}
}
