package com.ssafy.swea;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution_1954_달팽이숫자 {
	public static void main(String args[]) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			System.out.println("#" + N);
			
			int[][] snail = new int[N][N];	// 2차원 달팽이 배열 생성
											// 4 x 2 행렬 (방향)
			int[][] dir = { { 0, 1 },		// [0,0] [0,1] 우
							{ 1, 0 },		// [1,0] [1,1] 하
							{ 0, -1 },		// [2,0] [2,1] 좌
							{ -1, 0 } };	// [3,0] [3,1] 상

			int row = 0;					// 달팽이 배열의 행
			int col = -1;					// 달팽이 배열의 열

			int rDir = 0;					// 방향 배열의 행
			int cDir = 1;					// 방향 배열의 열

			int idx = 1;					// 달팽이 배열에 들어갈 값

			// 첫 시작 방향으로 N개의 값을 입력 (1번만 이루어짐)
			for (int i = 0; i < N; i++) {
				row += dir[rDir][cDir - 1];	
				col += dir[rDir][cDir];

				snail[row][col] = idx++;
			}

			// N이 1씩 줄어들고 0이 되면 입력 완료
			for (int i = N - 1; i > 0; i--) {
				// N개의 값을 입력 (2번 이루어짐)
				for (int j = 0; j < 2; j++) {
					rDir += 1;				// 방향 지정
					rDir %= 4;				// 방향 배열의 행의 크기는 4
					for (int k = i; k > 0; k--) {	// N개의 값 입력
						row += dir[rDir][cDir - 1];
						col += dir[rDir][cDir];

						snail[row][col] = idx++;
					}
				}
			}

			// 달팽이 배열 출력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}

		}

	}
}