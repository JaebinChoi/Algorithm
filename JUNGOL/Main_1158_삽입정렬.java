package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삽입정렬 횟수세기
public class Main_1158 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int count = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					count++;
					int tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}
			}
		}
		
		System.out.print(count);

	}
}
