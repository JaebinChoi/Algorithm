import java.util.Arrays;

class Solution_문자열내림차순으로배치하기 {
	public String solution(String s) {
		String answer = "";

		char[] ch = s.toCharArray();
		Arrays.sort(ch);

		for (int size = ch.length, i = size - 1; i >= 0; i--)
			answer += ch[i];

		return answer;
	}

	public static void main(String[] args) {
		String s = "Zbcdfg";

		System.out.println(new Solution_문자열내림차순으로배치하기().solution(s));
	}
}