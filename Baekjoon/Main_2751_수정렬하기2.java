import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2751_수정렬하기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		boolean[] numbers = new boolean[2000001];

		for (int i = 0; i < N; i++) {
			numbers[Integer.parseInt(br.readLine()) + 1000000] = true;
		}

		for (int i = 0; i < 2000001; i++) {
			if (numbers[i]) sb.append(i - 1000000).append('\n');
		}

		System.out.println(sb.toString());
	}
}
