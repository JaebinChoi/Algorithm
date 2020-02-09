package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효형검사 {
	static final String operator = "+-*/";

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/사칙연산.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int testcase = 1; testcase <= 10; testcase++) {
			int N = Integer.parseInt(br.readLine());
			boolean flag = true;

			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int tokens = st.countTokens();
				if (tokens == 4) {
					st.nextToken();
					if (!operator.contains(st.nextToken())) { // 2번째 => 연산자
						flag = false;
					}
					st.nextToken();
					st.nextToken();
				} else if (tokens == 2) {	// 리프 노드일 경우
					st.nextToken();
					if (operator.contains(st.nextToken())) { // 리프노드 => 숫자
						flag = false;
					}
				}
			}
			int result = flag ? 1 : 0;
			System.out.println("#" + testcase + " " + result);

		}

	}
}
