class Solution_타겟넘버 {
	static int[] numbers;
	static int target;
	static int result;

	public int solution(int[] input, int inp) {
		numbers = input;
		target = inp;

		dfs(0, 0);

		return result;
	}

	private void dfs(int idx, int sum) {
		if (idx == numbers.length) {
			if (sum == target) result++;
			return;
		}

		dfs(idx + 1, sum + numbers[idx]);
		dfs(idx + 1, sum - numbers[idx]);

	}

	public static void main(String[] args) {
		System.out.println(new Solution_타겟넘버().solution(new int[] { 1, 1, 1, 1, 1 }, 3));
	}
}