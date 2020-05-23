import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 순열 + DFS */
public class Solution_3234_준환이의양팔저울 {
	static int N, result;
	static int[] arr, pick;
	static boolean[] selected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			pick = new int[N];
			selected = new boolean[N];
			result = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			combination(0);
			System.out.println("#" + tc + " " + result);
		}
	}

	private static void combination(int cnt) {
		if(cnt == N) {
			put(0, 0, 0);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(selected[i]) continue;
			
			pick[cnt] = arr[i];
			selected[i] = true;
			combination(cnt + 1);
			selected[i] = false;
		}
	}

	private static void put(int cur, int left, int right) {
		if(right > left) return;
		if(cur == N) {
			result++;
			return;
		}

		put(cur + 1, left + pick[cur], right);
		put(cur + 1, left, right + pick[cur]);
	}
}
