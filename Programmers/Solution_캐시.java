package complete;
import java.util.LinkedList;

class Solution_캐시 {
	public int solution(int cacheSize, String[] cities) {
		LinkedList<String> cache = new LinkedList<>();
		int time = 0;

		// 캐시 사이즈가 0일 경우 따로 처리
		if (cacheSize == 0) return cities.length * 5;
		for (String city : cities) {
			city = city.toLowerCase();

			// 캐시에 존재할 경우
			if (cache.contains(city)) {
				cache.remove(city);
				cache.offer(city);
				time++;
				continue;
			}

			// 캐시가 꽉찬 경우
			if (cache.size() == cacheSize) cache.poll();

			cache.offer(city);
			time += 5;
		}
		return time;
	}

	public static void main(String[] args) {
		int cacheSize = 3;
		String[] cities = { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" };

		new Solution_캐시().solution(cacheSize, cities);
	}
}