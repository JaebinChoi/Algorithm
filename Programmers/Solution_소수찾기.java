import java.util.HashSet;
import java.util.Set;

class Solution_소수찾기 {
	static StringBuilder sb = new StringBuilder();
	static Set<Integer> primes = new HashSet<>();
	static Set<Integer> notPrimes = new HashSet<>();
	static String numbers;
	static int size;
	static boolean[] visited;

	public int solution(String s) {
		numbers = s;
		size = numbers.length();

		for (int i = 1; i <= size; i++) {
			visited = new boolean[size + 1];
			combination(0, i);
		}

		return primes.size();
	}

	private void combination(int cnt, int k) {
		if (cnt == k) {
			int number = Integer.parseInt(sb.toString());

			if (number < 2 || primes.contains(number) || notPrimes.contains(number)) return;
			if (isPrime(number)) primes.add(number);
			else notPrimes.add(number);
			return;
		}

		for (int i = 0; i < size; i++) {
			if (visited[i]) continue;

			visited[i] = true;
			sb.append(numbers.charAt(i));
			combination(cnt + 1, k);
			sb.deleteCharAt(sb.length() - 1);
			visited[i] = false;
		}
	}

	private boolean isPrime(int number) {
		for (int i = 2, len = (int) Math.sqrt(number); i <= len; i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String numbers = "17";

		new Solution_소수찾기().solution(numbers);
	}
}