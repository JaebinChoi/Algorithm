package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 선택정렬
public class Main_1146 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int idx;
		for (int i = 0; i < N - 1; i++) {
			idx = i;
			for (int j = i + 1; j < N; j++) {
				if (arr[j] < arr[idx])
					idx = j;
			}

			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;

			for (int n = 0; n < N; n++) {
				System.out.print(arr[n] + " ");
			}
			System.out.println();
		}

	}
}
