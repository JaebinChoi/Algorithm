import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1748_수이어쓰기1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int len = Integer.toString(n).length();
		int sum = 0;
		
		// 1자리수 * 9 * 1 = 9,	2자리수 * 9 * 10 = 180,	3자리수 * 9 * 100 = 2700
		for(int i = 1; i < len; i++)
			sum += i * 9 * Math.pow(10, i-1);
		
		// 원래 수 - 맨 앞의 자리수 + 1 = 맨 앞자리수의 개수
		// ex) 2234 => 2234 - 1000 + 1 = 1235(4자리수의 개수) * 4 = 4자리수의 총 길이
		n = n - (int)Math.pow(10, len-1) + 1;
		sum += (n * len);
		System.out.println(sum);
	}
}
