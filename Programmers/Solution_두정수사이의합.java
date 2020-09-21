class Solution_두정수사이의합 {
	public long solution(int a, int b) {
		long answer = 0;

		long from = a < b ? a : b;
		long to = a < b ? b : a;

		if (from >= 0 && to >= 0)
			answer = (to * (to + 1) / 2) - ((from - 1) * from / 2);
		else if (from < 0 && to >= 0) {
			from = Math.abs(from);
			answer = (to * (to + 1) / 2) - (from * (from + 1) / 2);
		} else {
			from = Math.abs(from);
			to = Math.abs(to);
			answer = -1 * ((from * (from + 1) / 2) - ((to - 1) * to / 2));
		}

		return answer;
	}

	public static void main(String[] args) {
		int a = -3;
		int b = -5;

		new Solution_두정수사이의합().solution(a, b);
	}
}