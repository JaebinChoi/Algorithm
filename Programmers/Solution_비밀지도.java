class Solution_비밀지도 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		String[] dec = new String[n];
		StringBuilder sb;

		for (int i = 0; i < n; i++) {
			dec[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
			if (dec[i].length() < n) {
				for (int j = 0, size = dec[i].length(); j < n - size ; j++) {
					dec[i] = "0" + dec[i];
				}
			}
		}

		for (int i = 0; i < n; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (dec[i].substring(j, j + 1).equals("1")) sb.append("#");
				else sb.append(" ");
			}
			answer[i] = sb.toString();
		}

		return answer;
	}

	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = { 0, 0, 0, 0, 0 };
		int[] arr2 = { 30, 1, 21, 17, 28 };

		new Solution_비밀지도().solution(n, arr1, arr2);
	}
}