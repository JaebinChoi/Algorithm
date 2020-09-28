import java.util.Arrays;
import java.util.Comparator;

class Solution_가장큰수 {
	public String solution(int[] numbers) {
		String answer = "";
		int size = numbers.length;

		String[] nums = new String[size];
		for (int i = 0; i < size; i++)
			nums[i] = Integer.toString(numbers[i]);

		// 내림차순 정렬
		Arrays.sort(nums, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});

		// 내림차순 정렬 했는데 0 시작일 경우 (ex.00000)
		if (nums[0].equals("0")) return nums[0];
		for (int i = 0; i < size; i++)
			answer += nums[i];

		return answer;
	}

	public static void main(String[] args) {
		int[] numbers = { 3, 30, 34, 5, 9 };

		new Solution_가장큰수().solution(numbers);
	}
}