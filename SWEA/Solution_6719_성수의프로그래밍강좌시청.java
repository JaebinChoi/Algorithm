import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6719_성수의프로그래밍강좌시청 {
	static int N, K;
	static int[] M;
	static double A;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/성수.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = 0;

			M = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				M[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(M);
			// 정렬 상태에서 가장 뒤에서 부터 K개 뽑아서 작은 순서대로 대입
			for (int i = N - K; i < N; i++) {
				A = (A + M[i]) / 2;
			}
			System.out.println("#" + tc + " " + A);
		}
	}
}
