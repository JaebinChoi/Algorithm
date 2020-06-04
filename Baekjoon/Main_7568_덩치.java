import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7568_덩치 {
	static class Node {
		int w;
		int h;

		public Node(int w, int h) {
			this.w = w;
			this.h = h;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node[] person = new Node[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			person[i] = new Node(w, h);
		}

		int[] rank = new int[N];
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				// 자기보다 둘다 큰 사람 찾기
				if (person[i].w < person[j].w && person[i].h < person[j].h)
					cnt++;
			}
			rank[i] = cnt;
		}

		for (int n : rank)
			System.out.print(n + " ");
	}
}
