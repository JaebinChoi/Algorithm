package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1208_Flatten {
	static int max;
	static int min;
	static int maxIdx;
	static int minIdx;

	public static void maxMin(int[] arr) {
		max = arr[0];
		min = arr[0];
		maxIdx = 0;
		minIdx = 0;
		for (int i = 1; i < arr.length; i++) { // 상자 순회하면서
			if (max < arr[i]) { // 높이가 가장 큰 상자
				max = arr[i];
				maxIdx = i;
			}
			if (min > arr[i]) { // 높이가 가장 작은 상자
				min = arr[i];
				minIdx = i;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/flatten.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int testcase = 1; testcase <= 10; testcase++) {
			int dump = Integer.parseInt(br.readLine()); // 덤프 횟수
			int[] box = new int[100]; // 100개의 상자 높이 배열
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < box.length; i++) { // 상자 높이 입력
				box[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < dump; i++) { // 덤프 횟수만큼 반복
				for (int j = 0; j < box.length; j++) { // 최대 최소값 찾기
					maxMin(box);
				}

				if (max - min > 1) { // 높이 큰 상자에서 높이 작은 상자로 옮김
					box[maxIdx]--;
					box[minIdx]++;
				} else { // max - min 차이가 1 이하일 경우 더이상 덤프할 필요 없음
					break;
				}
			} // dump
			
			maxMin(box); // 덤프 후 배열에서 최대 최소값 찾기
			System.out.println("#" + testcase + " " + (max - min));

		} // testcase
	} // main
}
