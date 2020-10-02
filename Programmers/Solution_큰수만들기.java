/** Greedy */
class Solution_큰수만들기 {
	public String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
		int cnt = 0;

		for (int i = 0, len = number.length(); i < len; i++) {
			char num = number.charAt(i);

			// 비교할게 없으면
			if (sb.length() == 0) {
				sb.append(num);
				continue;
			}

			// 현재 수 이전의 작은 수 삭제
			while (sb.length() > 0) {
				// 이전 수 > 현재 수
				if (sb.charAt(sb.length() - 1) >= num) break;

				sb.deleteCharAt(sb.length() - 1);
				cnt++;

				// 제거할 개수 충족
				if (cnt == k) break;
			}

			sb.append(num);

			// 다 삭제 했을 경우
			if (cnt == k) {
				sb.append(number.substring(i + 1, len));
				break;
			}
		}

		// 다 삭제 못했을 경우 뒤에서부터 삭제
		while (cnt != k) {
			sb.deleteCharAt(sb.length() - 1);
			cnt++;
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String number = "1924";
		int k = 2;

		new Solution_큰수만들기().solution(number, k);
	}
}