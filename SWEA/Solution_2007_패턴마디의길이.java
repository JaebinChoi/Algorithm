package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2007_패턴마디의길이 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/패턴마디길이.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine(); // 받아올 문자열
			String s = str.substring(0, 1); // 추가할 문자열
			String first = str.substring(0, 1); // 첫글자

			for (int i = 1; i < str.length() - 1; i++) {
				String tmp = str.substring(i, i + 1); // 한글자씩 추가

				if (first.equals(tmp)) { // 첫글자랑 글자가 같으면
					if (s.equals(str.substring(s.length(), s.length() * 2))) { // 잘라온 문자열이랑 다음 같은 길이의 문자열 비교
						break;
					}
				}
				s += tmp;
			}
			System.out.println("#" + tc + " " + s.length());
		}

	}
}
