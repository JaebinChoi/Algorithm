package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 조합
public class Main_6603_로또 {
	static int[] lotto;
	static int N;
	static int[] selected;
	static final int SELECTNUM = 6;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/로또.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N == 0)
				break;

			lotto = new int[N];
			selected = new int[SELECTNUM];

			for (int i = 0; i < N; i++) {
				lotto[i] = Integer.parseInt(st.nextToken());
			}

			pick(0, 0);
			System.out.println();
		}

	}

	private static void pick(int cnt, int start) {
		if (cnt == SELECTNUM) {
			for (int i = 0; i < 6; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < N; i++) {
			selected[cnt] = lotto[i];
			pick(cnt + 1, i + 1);
		}

	}

}
