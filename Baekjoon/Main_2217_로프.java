import java.util.Arrays;
import java.util.Scanner;

public class Main_2217_로프 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] ropes = new int[N];

		for (int i = 0; i < N; i++) {
			ropes[i] = sc.nextInt();
		}

		Arrays.sort(ropes);

		int result = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			result = result >= ropes[N - i] * i ? result : ropes[N - i] * i;
		}

		System.out.println(result);
	}
}
