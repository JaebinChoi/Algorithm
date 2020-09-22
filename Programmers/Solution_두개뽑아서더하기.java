import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Solution_두개뽑아서더하기 {
	public int[] solution(int[] numbers) {
		int size = numbers.length;
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}

		int[] answer = new int[set.size()];
		int idx = 0;
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			answer[idx++] = iterator.next();
		}

		Arrays.sort(answer);

		return answer;
	}

	public static void main(String[] args) {
		int[] numbers = { 5, 0, 2, 7 };

		System.out.println(Arrays.toString(new Solution_두개뽑아서더하기().solution(numbers)));
	}
}