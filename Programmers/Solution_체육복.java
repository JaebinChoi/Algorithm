class Solution_체육복 {
	public int solution(int n, int[] lost, int[] reserve) {
		int cnt = lost.length;
		
		// 본인의 여벌옷을 본인이 입는 경우
		for(int i = 0; i < lost.length; i++) {
			for(int j = 0; j < reserve.length; j++) {
				if(lost[i] == reserve[j]) {
					lost[i] = -1;		// 사용불가한 수로 변경
					reserve[j] = -1;	// 사용불가한 수로 변경
					cnt--;
					break;
				}
			}
		}
		
		// 여벌옷을 빌려주는 경우
		for(int i = 0; i < lost.length; i++) {
			for(int j = 0; j < reserve.length; j++) {
				if(Math.abs(lost[i] - reserve[j]) == 1) {
					reserve[j] = -1;	// 사용불가한 수로 변경
					cnt--;
					break;
				}
			}
		}
		
		return n - cnt;
	}

	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 2, 4  };
		int[] reserve = { 1, 3, 5 };

		System.out.println(new Solution_체육복().solution(n, lost, reserve));
	}
}