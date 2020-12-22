import java.util.Arrays;

class Solution_삼각달팽이 {
	public int[] solution(int n) {
		int[] answer = new int[n * (n + 1) / 2];
		int[][] triangle = new int[n][n];
		int N = n;

		int num = 1;
		int r = -1;
		int c = 0;
		int cnt = 0;
		int type = 0;
		while (true) {
			if (type == 0) triangle[++r][c] = num++;
			else if (type == 1) triangle[r][++c] = num++;
			else triangle[--r][--c] = num++;

			cnt++;

			if (cnt < n) continue;
			if (n == 1) break;

			cnt = 0;
			n--;
			type++;
			type %= 3;
		}

		int index = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				answer[index++] = triangle[i][j];
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution_삼각달팽이().solution(6)));
	}
}