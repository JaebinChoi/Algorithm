import java.util.Arrays;

class Solution_HIndex {
	public int solution(int[] citations) {
		int answer = 0;
		int len = citations.length;
		int index = 0;
		boolean flag = true;
		
		Arrays.sort(citations);
		for (int ci = 1; ci < 10001; ci++) {
			while (ci > citations[index]) {
				index++;
				if (index == len) {
					flag = !flag;
					break;
				}
			}
			
			if (!flag) break;
			if (len - index >= ci) answer = ci;
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new Solution_HIndex().solution(new int[] { 4, 4, 4, 5, 0, 1, 2, 3 }));
	}
}