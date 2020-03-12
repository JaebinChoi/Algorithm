package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution_7701_염라대왕의이름정렬 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/염라대왕.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.length() == o2.length()) {
						return o1.compareTo(o2);
					}
					return o1.length() - o2.length();
				}
			});

			for (int n = 0; n < N; n++) {
				set.add(br.readLine().trim());
			}

			sb.append("#").append(tc).append('\n');
			for (String str : set)
				sb.append(str).append('\n');
		} // testcase
		System.out.println(sb);
	} // main

}
