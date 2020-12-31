class Solution_땅따먹기 {
	int solution(int[][] land) {
		int R = land.length;

		for (int i = 1; i < land.length; i++) {
			land[i][0] = Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3])) + land[i][0];
			land[i][1] = Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3])) + land[i][1];
			land[i][2] = Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3])) + land[i][2];
			land[i][3] = Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2])) + land[i][3];
		}

		return Math.max(land[R - 1][0], Math.max(land[R - 1][1], Math.max(land[R - 1][2], land[R - 1][3])));
	}
}