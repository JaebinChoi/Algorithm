import java.util.Arrays;

class Solution_완주하지못하는선수 {
	public String solution(String[] participant, String[] completion) {
		int len = participant.length;
		Arrays.sort(participant);
		Arrays.sort(completion);

		String answer = participant[len - 1];
		for (int i = 0; i < len - 1; i++) {
			// 같은 위치에 이름이 다르면 하나가 더 끼여있다는 의미
			if (!participant[i].equals(completion[i])) {
				answer = participant[i];
				break;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		String[] participant = { "mislav", "stanko", "mislav", "ana" };
		String[] completion = { "stanko", "ana", "mislav" };

		System.out.println(new Solution_완주하지못하는선수().solution(participant, completion));
	}
}