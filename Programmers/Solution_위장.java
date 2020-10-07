import java.util.HashMap;
import java.util.Iterator;

/**
 * Hash
 * 
 * ex) 모자 2개, 옷 3개, 바지 2개
 * 모자 => 2 + 1 (안입는 경우) => 3
 * 옷    => 3 + 1 (안입는 경우) => 4
 * 바지 => 2 + 1 (안입는 경우) => 3
 * 모든 경우의 수 : 3 * 4 * 3 - 1 (모두 안입는 경우)
*/
class Solution_위장 {
	public int solution(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<>();
		int answer = 1;

		for (int i = 0, size = clothes.length; i < size; i++) {
			String str = clothes[i][1];
			if (map.keySet().contains(str)) map.put(str, map.get(str) + 1);
			else map.put(clothes[i][1], 1);
		}

		Iterator<Integer> iterator = map.values().iterator();
		while (iterator.hasNext()) {
			answer *= (iterator.next() + 1);
		}

		return answer - 1;
	}

	public static void main(String[] args) {
		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		
		System.out.println(new Solution_위장().solution(clothes));
	}
}