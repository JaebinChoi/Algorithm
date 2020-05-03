package staging;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
	static int N, M, sum;
	static int[][] map;
	static ArrayList<int[]> chicken, home, pick;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		chicken = new ArrayList<>();
		home = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2)
					chicken.add(new int[] { i, j });
				else if (map[i][j] == 1)
					home.add(new int[] { i, j });
			}
		}

		pick = new ArrayList<>();
		combination(0, 0);
		System.out.println(result);
	}

	private static void combination(int cnt, int cur) {
		if (cnt == M) {
			sum = 0;
			for (int i = 0, size1 = home.size(); i < size1; i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0, size2 = pick.size(); j < size2; j++) {
					int dist = Math.abs((home.get(i)[0] - pick.get(j)[0]))
							+ Math.abs((home.get(i)[1] - pick.get(j)[1]));
					min = dist < min ? dist : min;
				}
				sum += min;
			}
			result = result < sum ? result : sum;
		}

		for (int i = cur, size = chicken.size(); i < size; i++) {
			pick.add(chicken.get(i));
			combination(cnt + 1, i + 1);
			pick.remove(chicken.get(i));
		}
	}
} // class