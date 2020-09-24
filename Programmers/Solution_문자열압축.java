class Solution_문자열압축 {
	StringBuilder sb, result;

	public int solution(String s) {
		int answer = s.length();

		for (int i = 1, size = s.length(); i <= size / 2; i++) {
			sb = new StringBuilder(s);
			result = new StringBuilder();
			int cnt = 1;
			String target = null;

			for (int j = 0; j <= size - i; j += i) {
				String str = s.substring(j, j + i);
				sb.delete(0, i);

				if(target == null) target =	str;			// 첫 문자열
				else if (target.equals(str)) cnt++;			// 문자열 같음
				else {										// 문자열 다름
					if (cnt == 1) result.append(target);	// 중복 X
					else result.append(cnt).append(target);	// 중복 O (횟수)
					cnt = 1;								// 리셋
					target = str;							// 기준 문자열 변경
				}
			}
			// 마지막 부분
			if (cnt == 1) result.append(target);
			else result.append(cnt).append(target);

			// 남은 문자열 처리
			if (sb.length() > 0) result.append(sb);

			answer = answer < result.length() ? answer : result.length();
		}

		return answer;
	}
	
	public static void main(String[] args) {
		String s = "abcabcabcabcdededededede";
		
		System.out.println(new Solution_문자열압축().solution(s));
	}
}