package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {
	static int N;
	static int[][] map;
	static int result;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/요리사.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			result = Integer.MAX_VALUE;
			visited = new boolean[N];

			// 입력
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 2개의 시너지로 나누는 경우의 수(조합)
			combination(0, 0);

			System.out.println("#" + tc + " " + result);
		} // end of test case
	} // end of main

	private static void combination(int cur, int cnt) {
		if (cnt == N / 2) {
			// 시너지 값들의 합을 구함(순열)
			int value = getSynergy();
			result = result < value ? result : value;
			return;
		}
		for (int i = cur; i < N; i++) {
			visited[i] = true;
			combination(i + 1, cnt + 1);
			visited[i] = false;
		}
	}

	private static int getSynergy() {
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			if (visited[i])
				list1.add(i);
			else
				list2.add(i);
		}

		int synergy1 = 0, synergy2 = 0;
		for (int i = 0; i < N / 2 - 1; i++) {
			for (int j = i + 1; j < N / 2; j++) {
				synergy1 += map[list1.get(i)][list1.get(j)] + map[list1.get(j)][list1.get(i)];
				synergy2 += map[list2.get(i)][list2.get(j)] + map[list2.get(j)][list2.get(i)];
			}
		}
		return Math.abs(synergy1 - synergy2);
	}
} // end of class
