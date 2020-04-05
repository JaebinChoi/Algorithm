import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1699_제곱수의합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = i; // 1 + 1 + 1 + ...
			for (int j = 2; j * j <= i; j++) { // 제곱 수
				if (arr[i - j * j] + 1 < arr[i]) { // i보다 작은 1^2 ~ j^2 까지 해서 가장 작은 값에 + 1하기
					arr[i] = arr[i - j * j] + 1;
				}
			}
		}
		System.out.println(arr[N]);
	}
}
