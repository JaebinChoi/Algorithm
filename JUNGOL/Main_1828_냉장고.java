package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 최저온도 기준으로 오름차순 정렬
 * 
 * 첫번째 화학물질을 냉장고에 넣고
 * while() {
 * 	같은 냉장고에 들어갈 수 있는 조건
 * 	if (냉장고 내 화학물질들의 최고온도 중 MIN > 현재 화학물질의 최저 온도)
 * 		온도가 곂치기 때문에 냉장고에 넣기 가능
 * }
 */

public class Main_1828_냉장고 {
	static void swap(int x, int y, int[][] arr, int idx) {
		int tmp = arr[x][idx];
		arr[x][idx] = arr[y][idx];
		arr[y][idx] = tmp;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 화학물질 수
		int[][] tempers = new int[N][3]; // 최저, 최고 온도, 냉장보관 여부 배열
		StringTokenizer st;

		// 최저, 최고 온도 삽입
		for (int a = 0; a < N; a++) {
			st = new StringTokenizer(br.readLine(), " ");
			tempers[a][0] = Integer.parseInt(st.nextToken());
			tempers[a][1] = Integer.parseInt(st.nextToken());
		}

		// 최저 온도를 기준으로 오름차순 정렬
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - i - 1; j++) {
				if (tempers[j][0] > tempers[j + 1][0]) {
					swap(j, j + 1, tempers, 0);
					swap(j, j + 1, tempers, 1);
				}
			}
		}

		int chemi_cnt = 0; // 화학물질 개수
		int ref_cnt = 0; // 냉장고 개수
		int max_temp_min; // 최고 온도 중 최저 온도
		while (chemi_cnt != N) { // N개를 전부 보관하면 반복 종료
			max_temp_min = 10000; // 냉장고 내 화학물질들의 최고온도 중 최소값 변수 초기화
			for (int i = 0; i < N; i++) { // 정렬되어있는 전체 화학물질 탐색
				if (tempers[i][2] == 0 && max_temp_min >= tempers[i][0]) { // 냉장보관 X and 다음 화학물질의 최저온도가 가장 낮은 최고온도보다 같거나
																			// 낮을경우 냉장보관
					tempers[i][2] = 1;
					chemi_cnt++;
					// max_temp_min 값 갱신 / 최고 온도 범위를 좁혀간다
					if (max_temp_min > tempers[i][1]) { // 다음 화학물질의 최고온도가 이전 최고온도보다 작으면 작은 값을 대입
						max_temp_min = tempers[i][1];
					}
				}
			}
			ref_cnt++;
		}

		System.out.println(ref_cnt);

	}
}
