import java.util.ArrayList;
import java.util.Arrays;

public class Solution_같은숫자는싫어 {
	public int[] solution(int[] arr) {
		ArrayList<Integer> list = new ArrayList<>();

		int pre = arr[0];
		list.add(pre);
		for (int i = 1, size = arr.length; i < size; i++) {
			if (pre != arr[i]) {
				pre = arr[i];
				list.add(pre);
			}
		}

		int[] result = new int[list.size()];
		for (int i = 0, size = list.size(); i < size; i++)
			result[i] = list.get(i);

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 3, 3, 0, 1, 1 };

		System.out.println(Arrays.toString(new Solution_같은숫자는싫어().solution(arr)));
	}
}