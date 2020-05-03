package staging;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_4366_정식이의은행업무 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String binary = br.readLine();
			String tenary = br.readLine();

			StringBuilder tmp2;
			StringBuilder tmp3;

			loop:
			for (int i = 0, size2 = binary.length(); i < size2; i++) {
				tmp2 = new StringBuilder();
				tmp2.append(binary);
				int bi = (binary.charAt(i) - '0' + 1) % 2;
				tmp2.replace(i, i + 1, Integer.toString(bi));

				for (int j = 0, size3 = tenary.length(); j < size3; j++) {
					for (int k = 1; k < 3; k++) {
						tmp3 = new StringBuilder();
						tmp3.append(tenary);
						int te = (tenary.charAt(j) - '0' + k) % 3;
						tmp3.replace(j, j + 1, Integer.toString(te));

						if (Integer.parseInt(tmp2.toString(), 2) == Integer.parseInt(tmp3.toString(), 3)) {
							System.out.println("#" + tc + " " + Integer.parseInt(tmp2.toString(), 2));
							break loop;
						}
					}
				}
			} // brute-force
		} // testcase
	} // main
} // class
