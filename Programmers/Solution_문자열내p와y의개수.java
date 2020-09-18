class Solution_문자열내p와y의개수 {
	boolean solution(String s) {
		int cnt = 0;
		
		for (int i = 0, size = s.length(); i < size; i++) {
			if (s.charAt(i) == 'p' || s.charAt(i) == 'P') cnt++;
			else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') cnt--;
		}
		
		return cnt == 0 ? true : false;
	}

	public static void main(String[] args) {
		String s = "Pyy";

		System.out.println(new Solution_문자열내p와y의개수().solution(s));
	}
}