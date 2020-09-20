class Solution_문자열다루기기본 {
	public boolean solution(String s) {
		String number = "1234567890";
		int size = s.length();

		if (size != 4 && size != 6) return false;
		
		for (int i = 0; i < size; i++)
			if (!number.contains(String.valueOf(s.charAt(i))))
				return false;

		return true;
	}

	public static void main(String[] args) {
		String s = "a234";

		System.out.println(new Solution_문자열다루기기본().solution(s));
	}
}