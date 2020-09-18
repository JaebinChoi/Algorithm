import java.util.Arrays;
import java.util.Comparator;

class Solution_문자열내마음대로정렬하기 {
	public String[] solution(String[] strings, int n) {

		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.charAt(n) == o2.charAt(n)) {
					int idx = 0;
					while (o1.charAt(idx) == o2.charAt(idx)) {
						idx++;
					}
					return o1.charAt(idx) - o2.charAt(idx);
				}
				return o1.charAt(n) - o2.charAt(n);
			}
		});

		System.out.println(Arrays.toString(strings));

		return strings;
	}

	public static void main(String[] args) {
		String[] strings = { "abce", "abcd", "cdx" };
		int n = 1;

		new Solution_문자열내마음대로정렬하기().solution(strings, n);
	}
}