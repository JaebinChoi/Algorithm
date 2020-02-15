package swea;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_7728_다양성측정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			int cnt = 0;

			String str = sc.next();

			for (int i = 0; i < str.length(); i++) {
				int num = Integer.parseInt(str.substring(i, i + 1));
				if (!list.contains(num)) {
					list.add(num);
				}
			}
			while (!list.isEmpty()) {
				list.remove(0);
				cnt++;
			}
			System.out.println("#" + tc + " " + cnt);

		}
	}
}
