import java.util.Arrays;

class Solution_주식가격 {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		// 순회
		for(int i = 0, size = prices.length; i < size; i++) {
			int price = prices[i];
			int cnt = 0;
			
			// 비교
			for(int j = i + 1; j < size; j++) {
				cnt++;
				if(price > prices[j]) break;
			}
			answer[i] = cnt;
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3, };
		
		System.out.println(Arrays.toString(new Solution_주식가격().solution(prices)));
	}
}