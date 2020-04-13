package com.ssafy.greedy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1370_회의실배정 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/bank/회의실배정.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] time = new int[N][4];

		for (int c = 0; c < N; c++) {
			st = new StringTokenizer(br.readLine());

			time[c][0] = Integer.parseInt(st.nextToken());
			time[c][1] = Integer.parseInt(st.nextToken());
			time[c][2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(time, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				// 오른차순 o1 - o2 내림차순 o2 - o1
				int gap = o1[2] - o2[2];
				return gap;
			}
		});

		LinkedList<Integer> roomsNum = new LinkedList<>();
		int num = 1;
		int etime = time[0][2];
		roomsNum.add(time[0][0]);

		for (int i = 1; i < N; i++) {
			if (etime <= time[i][1]) {
				num++;
				etime = time[i][2];
				roomsNum.add(time[i][0]);
			}
		}

		System.out.println(num);
		for (Integer n : roomsNum) {
			System.out.print(n + " ");
		}

	}

}
