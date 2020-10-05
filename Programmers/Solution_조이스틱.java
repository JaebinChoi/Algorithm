class Solution_조이스틱 {
	public int solution(String name) {
		int answer = 0;
		int cur = 0;
		int to = 0;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < name.length(); i++) sb.append("A");

		while (true) {
			int dis = Integer.MAX_VALUE;

			for (int i = 0, size = name.length(); i < size; i++) {
				if (name.charAt(i) != sb.charAt(i)) {
					// 좌우 이동
					int left = Math.abs(i - cur);
					int right = (size + cur) - i;
					
					// 좌우 중 짧은 곳
					if (Math.min(left, right) < dis) {
						dis = Math.min(left, right); // 거리
						to = i;						 // 목표 idx
					}
				}
			}
			// 글자가 전부 같을 경우
			if (dis == Integer.MAX_VALUE) break;
			
			// 상하 이동
			int up = name.charAt(to) - 'A';
			int down = 'Z' + 1 - name.charAt(to);
			
			// 가로 이동 + 세로 이동
			answer += dis + Math.min(up, down);
			
			// 해당 위치 글자 맞춰주기
			sb.replace(to, to + 1, String.valueOf(name.charAt(to)));
			
			// 현재 idx 변경
			cur = to;
		}

		return answer;
	}

	public static void main(String[] args) {
		String name = "JEROEN";

		System.out.println(new Solution_조이스틱().solution(name));
	}
}