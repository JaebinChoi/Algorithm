package com.ssafy.greedy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2247_도서관 {
	static class Library implements Comparable<Library> {
		int inTime;
		int outTime;

		public Library(int inTime, int outTime) {
			this.inTime = inTime;
			this.outTime = outTime;
		}

		@Override
		public int compareTo(Library o) {
			// 오른차순 o1 - o2 내림차순 o2 - o1
			int time = inTime - o.inTime;
			if (time == 0) {
				time = outTime - o.outTime;
			}
			return time;
		}

		@Override
		public String toString() {
			return "Library [inTime=" + inTime + ", outTime=" + outTime + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/bank/도서관.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Library[] library = new Library[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			library[i] = new Library(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(library);

		int stayTemp = library[0].outTime - library[0].inTime; // 첫 학생이 도서관에 머문 시간
		int longStayTime = stayTemp; // 도서관에 학생들이 끊기지 않고 머문 시간
		int emptyTime = 0; // 도서관에 학생들이 없던 시간
		int out = library[0].outTime; // 첫 학생이 도서관에서 떠난 시간

		for (int i = 1; i < N; i++) {
			// 학생이 도서관에 머문시간이 없을 경우, 다음 학생의 머문시간과 떠난시간으로 갱신
			if (stayTemp == 0) { 
				stayTemp = library[i].outTime - library[i].inTime;
				out = library[i].outTime;
				emptyTime = library[i].inTime - library[i - 1].outTime;
			}
			// 다음 학생의 도착시간이 이전 학생들의 떠난 시간 중 큰 값보다 작을 경우
			else if (library[i].inTime <= out) {
				// 다음 학생의 떠난시간이 이전 학생들의 떠난 시간보다 클 경우
				if (library[i].outTime > out) {
					stayTemp += library[i].outTime - out;
					out = library[i].outTime;
				}
			}
			// 다음 학생의 도착 시간이 이전 학생들의 떠난 시간 다음일 경우
			else {
				emptyTime = Math.max(emptyTime, library[i].inTime - out);
				longStayTime = Math.max(longStayTime, stayTemp);
				stayTemp = library[i].outTime - library[i].inTime;
				out = library[i].outTime;
			}

		}
		// 두번째 조건문을 돌다 끝나는 경우 존재함
		longStayTime = Math.max(longStayTime, stayTemp);

		System.out.println(longStayTime + " " + emptyTime);

	}

}
