import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6987_월드컵 {
	static final int N = 6;
	static int[][] country;
	static boolean isPossible;
	static int[] team1 = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
	static int[] team2 = { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		country = new int[6][3];

		for (int n = 0; n < 4; n++) {
			isPossible = false;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int win = 0;
			int draw = 0;
			int lose = 0;

			for (int i = 0; i < N; i++) {
				win += country[i][0] = Integer.parseInt(st.nextToken());
				draw += country[i][1] = Integer.parseInt(st.nextToken());
				lose += country[i][2] = Integer.parseInt(st.nextToken());
			}

			if (win + draw + lose == 30)
				combination(0);
			sb.append(isPossible ? 1 : 0).append(" ");
		}
		System.out.println(sb.toString());
	}

	private static void combination(int game) {
		if (game == 15) {
			isPossible = true;
			return;
		}

		int t1 = team1[game];
		int t2 = team2[game];

		// 승 : 패
		if (country[t1][0] > 0 && country[t2][2] > 0) {
			country[t1][0]--;
			country[t2][2]--;
			combination(game + 1);
			country[t1][0]++;
			country[t2][2]++;
		}

		// 패 : 승
		if (country[t1][2] > 0 && country[t2][0] > 0) {
			country[t1][2]--;
			country[t2][0]--;
			combination(game + 1);
			country[t1][2]++;
			country[t2][0]++;
		}

		// 비김
		if (country[t1][1] > 0 && country[t2][1] > 0) {
			country[t1][1]--;
			country[t2][1]--;
			combination(game + 1);
			country[t1][1]++;
			country[t2][1]++;
		}
	}
}
