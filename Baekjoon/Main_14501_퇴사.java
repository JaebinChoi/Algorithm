import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main_14501_퇴사 {
	static int N, result;
	static Node[] counsel;

	static class Node {
		int day;
		int value;

		public Node(int day, int value) {
			this.day = day;
			this.value = value;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		counsel = new Node[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			counsel[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		dfs(0, 0);
		System.out.println(result);
	}

	private static void dfs(int cur, int value) {
		if (cur >= N) {
			result = result > value ? result : value;
			return;
		}

		dfs(cur + 1, value); // 상담 안하고 다음날로
		if (cur + counsel[cur].day <= N) { // 퇴사 전 상담 가능한 날이면
			if (counsel[cur].day == 1) dfs(cur + 1, value + counsel[cur].value); // 당일 상담
			else dfs(cur + counsel[cur].day, value + counsel[cur].value); // 이틀 이상의 상담 후 끝난 날로
		}
	}
}
