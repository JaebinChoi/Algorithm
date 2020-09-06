import java.util.Arrays;

class Solution_K번째수 {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int from, to, idx;
		int[] sub;

		for (int i = 0, size = commands.length; i < size; i++) {
			from = commands[i][0] - 1; to = commands[i][1]; idx = commands[i][2] - 1;
			
			sub = Arrays.copyOfRange(array, from, to);
			Arrays.sort(sub);
			answer[i] = sub[idx];
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		System.out.println(Arrays.toString(new Solution_K번째수().solution(array, commands)));
	}
}