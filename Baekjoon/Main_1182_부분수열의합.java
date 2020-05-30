package staging;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182_부분수열의합 {
	static int N, S, result;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		dfs(0, 0);
		System.out.println(S == 0 ? --result : result); // 공집합일경우 고려
	}

	private static void dfs(int cur, int sum) {
		if(cur == N) {
			if(sum == S) result++;
			return;
		}
		
		dfs(cur + 1, sum + arr[cur]); 	// 선택
		dfs(cur + 1, sum); 				// 선택 x
	}
}
