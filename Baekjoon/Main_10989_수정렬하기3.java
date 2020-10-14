import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10989_수정렬하기3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] numbers = new int[T];

		for (int i = 0; i < T; i++)
			numbers[i] = Integer.parseInt(br.readLine());

		Arrays.sort(numbers);
		for (int num : numbers)
			sb.append(num).append("\n");

		System.out.println(sb.toString());
	}
}