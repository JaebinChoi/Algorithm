import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1041_주사위 {
	static final int M = 6;
	static long N;
	static long result;
	static Dice[] dice;
	static long[] minTotal;
	static Dice minDice;

	static class Dice implements Comparable<Dice> {
		int idx;
		int number;

		public Dice(int idx, int number) {
			this.idx = idx;
			this.number = number;
		}

		@Override
		public int compareTo(Dice o) {
			return Integer.compare(this.number, o.number);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dice = new Dice[M];
		minTotal = new long[4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			dice[i] = new Dice(i, Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(dice);
		
		// 1면, 2면, 3면의 최소 합 구하기
		getMinimum();

		if (N == 1) result = dice[0].number + dice[1].number + dice[2].number + dice[3].number + dice[4].number;
		else if (N == 2) result = 2 * 2 * (minTotal[3] + minTotal[2]);
		else {
			long cnt = N * 3 - 2 - 2;
			result = 2 * (2 * minTotal[3] + cnt * minTotal[2] + (N - 2) * (N - 1) * minTotal[1]);
			result += (N - 2) * (2 * minTotal[2] + cnt * minTotal[1]);
		}

		System.out.println(result);
	}

	private static void getMinimum() {
		minTotal[1] = dice[0].number;
		minTotal[2] = Integer.MAX_VALUE;
		minTotal[3] = Integer.MAX_VALUE;

		for (int i = 0; i < M; i++) {
			for (int j = i + 1; j < M; j++) {
				// 서로 인접하지 않은 반대편의 수일 경우
				if (dice[i].idx + dice[j].idx == 5) continue;
				
				long temp = dice[i].number + dice[j].number;
				minTotal[2] = minTotal[2] > temp ? temp : minTotal[2];

				for (int k = j + 1; k < M; k++) {
					if (dice[i].idx + dice[k].idx == 5 || dice[j].idx + dice[k].idx == 5) continue;
					
					temp = dice[i].number + dice[j].number + dice[k].number;
					minTotal[3] = minTotal[3] > temp ? temp : minTotal[3];
				}
			}
		}
	} // method
} // class
