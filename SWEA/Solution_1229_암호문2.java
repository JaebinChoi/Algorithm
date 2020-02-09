package com.ssfay.list;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution1229_암호문2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/1228_암호문2.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		// sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {
			int len = sc.nextInt(); // 원본 암호문의 길이
			LinkedList<Integer> list = new LinkedList<>();
			LinkedList<Integer> addList = new LinkedList<>();

			for (int i = 0; i < len; i++) {
				list.add(sc.nextInt()); // 원본 암호문
			}

			int promptNum = sc.nextInt(); // 명령어의 개수
			for (int i = 0; i < promptNum; i++) {
				char opt = sc.next().charAt(0); // I, D 추출
				int idx = sc.nextInt(); // 위치
				int num = sc.nextInt(); // 개수

				if (opt == 'I') {
					for (int j = 0; j < num; j++) {
						int ciper = sc.nextInt();	// 추가 암호문
						addList.add(ciper);
					}

					list.addAll(idx, addList);
					addList.clear();
				} else {
					for (int j = 0; j < num; j++) {
						list.remove(idx);
					}
				}
			}

			System.out.print("#" + testcase + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();

		}

	}
}
