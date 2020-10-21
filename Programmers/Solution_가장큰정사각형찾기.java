class Solution_가장큰정사각형찾기 {
	static int[][] dp;
	static int R, C;
	static int result = 0;

	public int solution(int[][] board) {
		dp = board;
		R = board.length;
		C = board[0].length;

		// 1줄일 경우
		for (int c = 0; c < C; c++) {
			if (board[0][c] == 1) {
				result = 1;
			}
		}

		// 왼쪽, 위, 왼대각선 중 가장 작은 값 찾기
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (board[i][j] == 1) {
					int min = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
					dp[i][j] = min + 1;
					result = result < dp[i][j] ? dp[i][j] : result;
				}
			}
		}
		return result * result;
	}

	public static void main(String[] args) {
		int[][] board = { { 1, 0 } }; // { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };
		System.out.println(new Solution_가장큰정사각형찾기().solution(board));
	}
}