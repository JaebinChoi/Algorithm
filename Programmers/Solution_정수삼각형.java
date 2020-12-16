class Solution_정수삼각형 {
	public int solution(int[][] triangle) {
		int answer = 0;
		int n = triangle.length;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) triangle[i][j] += triangle[i - 1][j];
				else if (j == i) triangle[i][j] += triangle[i - 1][j - 1];
				else triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
			}
		}

		for (int i = 0; i < n; i++) {
			answer = triangle[n - 1][i] > answer ? triangle[n - 1][i] : answer;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		new Solution_정수삼각형().solution(triangle);
	}
}