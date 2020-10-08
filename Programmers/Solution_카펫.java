import java.util.Arrays;

/** Brute-Force */
class Solution_카펫 {
	static int N, R, C;

	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		N = brown + yellow;

		for (int i = 3, size = (int) Math.sqrt(N); i < size + 1; i++) {
			if (N % i == 0) {
				R = i < (N / i) ? i : (N / i);
				C = i > (N / i) ? i : (N / i);
				if ((R + C) * 2 - 4 == brown) {
					answer[0] = C;
					answer[1] = R;
					break;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int brown = 24;
		int yellow = 24;

		System.out.println(Arrays.toString(new Solution_카펫().solution(brown, yellow)));
	}
}