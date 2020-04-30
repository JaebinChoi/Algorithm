package staging;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4050_재관이의대량할인 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(arr);
			int sum = 0;
			int cnt = 0;
			for(int i = n-1; i >= 0; i--) {
				if(cnt == 2) {
					cnt = 0;
					continue;
				}
				sum += arr[i];
				cnt++;
			}
			
			System.out.println("#" + tc + " " + sum);
		} // testcase
	} // main
} // class
