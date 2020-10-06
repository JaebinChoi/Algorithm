import java.util.Arrays;

class Solution_구명보트 {
	public int solution(int[] people, int limit) {
		int answer = 0;
		int small = 0;
		int big = people.length - 1;
		Arrays.sort(people);

		while (true) {
			if (people[big] + people[small] <= limit) small++; 	// 몸무게가 가장 작은 사람이 낑겨탈 수 있으면 태운다.
			big--; 												// 몸무게가 가장 큰 사람을 보트에 태운다.
			answer++; 											// 보트 1개 추가

			if (big > small) continue;							// 아직 다 안태웠으면 태우러~
			if (big == small) answer++;							// 마지막 한 사람
			break;												// 다 태움
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new Solution_구명보트().solution(new int[] { 70, 80, 50 }, 100));
	}
}