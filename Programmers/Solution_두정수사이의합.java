class Solution_두정수사이의합 {
	public long solution(int a, int b) {
		int from = a < b ? a : b;
		int to = a < b ? b : a;
		
		int sum = 0;
		for(int i = from; i <= to; i++)
			sum += i;
		
		return sum;
	}

	public static void main(String[] args) {
		int a = -5;
		int b = 3;

		System.out.println(new Solution_두정수사이의합().solution(a, b));
	}
}