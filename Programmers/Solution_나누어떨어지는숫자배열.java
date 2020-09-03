import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution_나누어떨어지는숫자배열 {
	public int[] solution(int[] arr, int divisor) {
		int[] answer = {};
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0, size = arr.length; i < size; i++)
			if (arr[i] % divisor == 0) list.add(arr[i]);
		
		if(list.size() == 0) return new int[] {-1};

		Collections.sort(list);
		answer = new int[list.size()];
		
		for (int i = 0, size = list.size(); i < size; i++)
			answer[i] = list.get(i);

		return answer;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 9, 7, 10 };
		int divisor = 5;

		System.out.println(Arrays.toString(new Solution_나누어떨어지는숫자배열().solution(arr, divisor)));
	}
}