package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {
	static int L, C;
	static char[] alph, temp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		alph = new char[C];
		temp = new char[L];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++)
			alph[i] = st.nextToken().charAt(0);

		Arrays.sort(alph);

		comb(0, 0, 0, 0);
		System.out.println(sb.toString());
	}

	private static void comb(int cur, int cnt, int ja, int mo) {
		if (cnt == L) {
			if (ja >= 2 && mo >= 1) {
				for (int i = 0; i < L; i++) {
					sb.append(temp[i]);
				}
				sb.append("\n");
				return;
			}
			else
				return;
		}
		for (int i = cur; i < C; i++) {
			temp[cnt] = alph[i];
			if (checkMoem(i))
				comb(i + 1, cnt + 1, ja, mo + 1);
			else
				comb(i + 1, cnt + 1, ja + 1, mo);
		}
	}

	private static boolean checkMoem(int x) {
		if (alph[x] == 'a' || alph[x] == 'e' || alph[x] == 'i' || alph[x] == 'o' || alph[x] == 'u')
			return true;
		return false;
	}
}
