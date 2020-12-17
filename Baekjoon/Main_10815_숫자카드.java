import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815_숫자카드 {
	static int N;
	static int[] num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			sb.append(BinarySearch(Integer.parseInt(st.nextToken())) ? 1 : 0).append(" ");
		}
		System.out.println(sb.toString());
	}

	private static boolean BinarySearch(int number) {
		int left = 0;
		int right = N - 1;

		while (true) {
			int mid = (right + left) / 2;

			if (num[mid] == number) return true;

			if (number > num[mid]) left = mid + 1;
			else right = mid - 1;

			if (left > right) break;
		}

		return false;
	}
}
