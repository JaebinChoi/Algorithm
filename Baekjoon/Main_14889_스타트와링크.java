import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main_14889_스타트와링크 {
	static int N, result = Integer.MAX_VALUE;
	static int[][] map;
	static LinkedList<Integer> pick = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0, 0);
		System.out.println(result);
	}

	private static void combination(int cur, int cnt) {
		if(cnt == N / 2) {
			int sum = calculate();
			result = result < sum ? result : sum;
			return;
		}

		for(int i = cur; i < N; i++) {
			pick.offer(i);
			combination(i + 1, cnt + 1);
			pick.pollLast();
		}
	}

	private static int calculate() {
		ArrayList<Integer> nonpick = new ArrayList<>();
		for(int i = 0; i < N; i++)
			if(!pick.contains(i)) nonpick.add(i);
		
		int sum1 = 0;
		int sum2 = 0;
		for(int i = 0; i < N / 2; i++) {
			for(int j = i + 1; j < N / 2; j++) {
				sum1 += map[pick.get(i)][pick.get(j)] + map[pick.get(j)][pick.get(i)];
				sum2 += map[nonpick.get(i)][nonpick.get(j)] + map[nonpick.get(j)][nonpick.get(i)];
			}
		}
		
		return Math.abs(sum1 - sum2);
	}
}
