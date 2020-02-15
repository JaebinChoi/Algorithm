package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8741_두문자어 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			String str = "";
			int num = st.countTokens();

			for (int i = 0; i < num; i++) {
				str += st.nextToken().toUpperCase().substring(0, 1);
			}
			System.out.println("#" + tc + " " + str);
		}

	}
}
