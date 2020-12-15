class Solution_단어변환 {
	static int N;
	static String[] words;
	static boolean[] visited;
	static int result = Integer.MAX_VALUE;

	public int solution(String begin, String target, String[] inputs) {
		N = inputs.length;
		words = inputs;
		visited = new boolean[N];

		dfs(begin, target, 0);

		return result != Integer.MAX_VALUE ? result : 0;
	}

	private void dfs(String current, String target, int depth) {
		if (current.equals(target)) {
			result = depth < result ? depth : result;
			return;
		}

		for (int i = 0; i < N; i++) {
			String next = words[i];

			if (visited[i] || !checkDiffOneChar(current, next)) {
				continue;
			}

			visited[i] = true;
			dfs(next, target, depth + 1);
			visited[i] = false;
		}

	}

	// 두 단어를 비교해서 1개만 다르면 true, 그렇지 않으면 false를 반환
	private boolean checkDiffOneChar(String current, String next) {
		int len = current.length();
		int same = 0;

		for (int j = 0; j < len; j++) {
			if (current.charAt(j) == next.charAt(j)) {
				++same;
			}
		}

		return same == len - 1 ? true : false;
	}

	public static void main(String[] args) {
		String[] words = { "hhh", "hht" }; // { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(new Solution_단어변환().solution("hit", "hhh", words));
	}
}