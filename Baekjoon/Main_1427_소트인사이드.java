import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1427_소트인사이드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] numbers = br.readLine().toCharArray();
		Arrays.sort(numbers);
		
		for (char num : numbers)
			sb.append(num);

		System.out.println(sb.reverse().toString());
	}
}
