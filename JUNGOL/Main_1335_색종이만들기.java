package com.ssafy.divideconquer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1335_색종이만들기 {
	static int N;
	static int[][] paper;
	static int blue;
	static int white;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/im/색종이만들기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cut(0, 0, N - 1, N - 1);
		System.out.println(white);
		System.out.println(blue);

	}

	private static void cut(int sr, int sc, int er, int ec) {
		int check = paper[sr][sc];
		int midr = (sr + er) / 2;
		int midc = (sc + ec) / 2;

		boolean flag = true;
		loop: for (int i = sr; i <= er; i++) {
			for (int j = sc; j <= ec; j++) {
				if (check != paper[i][j]) {
					flag = false;
					break loop;
				}
			}
		}

		if (flag) {
			if (check == 1)
				blue++;
			else
				white++;
		} else {
			cut(sr, sc, midr, midc);
			cut(sr, midc + 1, midr, ec);
			cut(midr + 1, sc, er, midc);
			cut(midr + 1, midc + 1, er, ec);
		}

	}

}
