import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1204_최빈수구하기 {
	static int[] scores;
	static int frequency; // 제일 빈도가 많은 수

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/최빈수.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			scores = new int[101];
			frequency = Integer.MIN_VALUE;
			br.readLine();

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < 1000; i++) {
				scores[Integer.parseInt(st.nextToken())]++;
			}

			int max = 0;
			for (int i = 0; i < 101; i++) {
				if (scores[i] >= frequency) {
					frequency = scores[i];
					max = i;
				}
			}

			System.out.println("#" + tc + " " + max);
		}
	}
}
