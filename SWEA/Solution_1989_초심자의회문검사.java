package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_1989_초심자의회문검사 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/초심자의회문찾기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine().trim();
			int result = 1;

			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
					result = 0;
				}
			}

			System.out.println("#" + tc + " " + result);
		}

	}

}
