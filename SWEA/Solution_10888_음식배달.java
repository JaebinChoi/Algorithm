import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_10888_음식배달 {
	static int N, answer;
	static int[][] map;
	static ArrayList<Pos> house, eatery, picked;

	static class Pos {
		int r;
		int c;
		int value;

		public Pos(int r, int c, int value) {
			this.r = r;
			this.c = c;
			this.value = value;
		}
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("테스트.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			answer = Integer.MAX_VALUE;
			map = new int[N][N];
			house = new ArrayList<>();
			eatery = new ArrayList<>();
			picked = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 0) continue;
					else if (map[i][j] == 1) house.add(new Pos(i, j, 0));
					else eatery.add(new Pos(i, j, map[i][j]));
				}
			}

			// 1개 ~ eatery.size()개로 조합 구하기
			for (int i = 1, size = eatery.size(); i <= size; i++)
				combination(0, 0, i);
			
			System.out.println("#" + tc + " " + answer);
		} // test case
	} // main

	// end개 식당의 조합을 구하는 메소드
	private static void combination(int cur, int cnt, int end) {
		if (cnt == end) {
			int get = getMinimum();
			answer = get < answer ? get : answer;
			return;
		}

		for (int i = cur, size = eatery.size(); i < size; i++) {
			picked.add(eatery.get(i));
			combination(i + 1, cnt + 1, end);
			picked.remove(picked.size() - 1);
		}
	}

	// 최소값 구하기
	private static int getMinimum() {
		int result = 0;
		
		// 음식배달점의 운용비
		for (int i = 0, size = picked.size(); i < size; i++)
			result += picked.get(i).value;

		// 집과 음식배달점 간의 거리 구하기
		for (int i = 0, houseSize = house.size(); i < houseSize; i++) {
			Pos h = house.get(i);
			int minimum = Integer.MAX_VALUE;

			// 거리가 가장 짧은 음식배달점 구하기
			for (int j = 0, eaterySize = picked.size(); j < eaterySize; j++) {
				Pos e = picked.get(j);

				int distance = getDistance(h.r, h.c, e.r, e.c);
				minimum = distance < minimum ? distance : minimum;
			}

			result += minimum;
			if (result > answer) return Integer.MAX_VALUE;
		}
		return result;
	}

	// 거리 구하는 메소드
	private static int getDistance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
}

/*
4
5
0 0 0 0 0
0 1 1 1 0
0 1 10 1 0
0 1 1 1 0 
0 0 0 0 0
8
0 0 0 0 0 0 0 0
0 1 1 1 0 0 0 0
0 1 10 1 0 0 0 0
0 1 1 1 0 0 0 0
0 0 0 0 1 1 1 0
0 0 0 0 1 10 1 0
0 0 0 0 1 1 1 0
0 0 0 0 0 0 0 0
8
0 0 0 0 0 0 0 0
0 1 1 1 0 0 0 0
0 1 20 1 0 0 0 0
0 1 1 1 0 0 0 0
0 0 0 0 1 1 1 0
0 0 0 0 1 30 1 0
0 0 0 0 1 1 1 0
0 0 0 0 0 0 0 0
9
0 0 0 0 0 0 0 0 0
0 5 0 0 5 0 0 5 0
0 0 1 0 1 0 1 0 0
0 0 0 0 0 0 0 0 0
0 5 1 0 30 0 1 5 0
0 0 0 0 0 0 0 0 0
0 0 1 0 1 0 1 0 0
0 5 0 0 5 0 0 5 0
0 0 0 0 0 0 0 0 0
*/
