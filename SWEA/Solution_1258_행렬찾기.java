package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_1258_행렬찾기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/행렬찾기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			int[][] res = new int[n * 2][3]; // 행개수, 열개수, 크기

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int arrcnt = 0; // 사각형 개수
			int rcnt = 0; // 행 개수
			int ccnt = 0; // 열 개수
			int row = 0; // 순회할 행
			int col = 0; // 순회할 열
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					rcnt = 0;
					ccnt = 0;
					if (arr[i][j] != 0) { // 숫자가 있으면
						row = i; // 숫자가 있는 행의 인덱스
						col = j; // 숫자가 있는 열의 인덱스

						while (row < n && arr[row][j] != 0) { // 행단위로 배열을 벗어나지 않고 숫자가 있을때까지
							rcnt++; // 행 개수 + 1
							row++; // 순회할 행 + 1
						}
						while (col < n && arr[i][col] != 0) { // 열단위
							ccnt++;
							col++;
						}

						// 행개수, 열개수, 크기
						res[arrcnt][0] = rcnt;
						res[arrcnt][1] = ccnt;
						res[arrcnt++][2] = rcnt * ccnt;

						// 찾은 사각형 0으로 바꿔주기
						for (int a = i; a < i + rcnt; a++) {
							for (int b = j; b < j + ccnt; b++) {
								arr[a][b] = 0;
							}
						}

					}

				}
			}

			int[][] result = new int[arrcnt][3]; // 결과 저장한 배열
			for (int i = 0; i < arrcnt; i++) {
				for (int j = 0; j < 3; j++) {
					result[i][j] = res[i][j];
				}
			}

			// 크기로 오름차순 정렬, 같으면 행으로 오름차순 정렬
			Arrays.sort(result, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[2] <= o2[2])
						return -1;
					else if (o1[2] == o2[2])
						return o1[0] - o2[0];
					else
						return 1;
				}
			});

			System.out.print("#" + tc + " " + arrcnt + " ");
			for (int i = 0; i < arrcnt; i++) {
				for (int j = 0; j < 2; j++) {
					System.out.print(result[i][j] + " ");
				}
			}
			System.out.println();

		} // tc

	}
}
