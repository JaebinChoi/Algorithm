package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2740_행렬곱셈 {
	static int[][] A, B, C;
	static int N, M;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/행렬곱셈.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
		for (int i = 0; i < A.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < A[i].length; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		B = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
		for (int i = 0; i < B.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < B[i].length; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		C = new int[A.length][B[0].length];
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C[i].length; j++) {
				int sum = 0;
				for (int k = 0; k < B.length; k++) {
					sum += A[i][k] * B[k][j];
				}
				C[i][j] = sum;
			}
		}

		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C[i].length; j++) {
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}

	}
}
