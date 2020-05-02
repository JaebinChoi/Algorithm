package staging;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[][] cost = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cost[0][0] = arr[0][0];
		cost[0][1] = arr[0][1];
		cost[0][2] = arr[0][2];

		for (int i = 1; i < N; i++) {
			cost[i][0] = Math.min(cost[i - 1][1], cost[i - 1][2]) + arr[i][0];
			cost[i][1] = Math.min(cost[i - 1][0], cost[i - 1][2]) + arr[i][1];
			cost[i][2] = Math.min(cost[i - 1][0], cost[i - 1][1]) + arr[i][2];
		}

		System.out.println(Math.min(Math.min(cost[N - 1][0], cost[N - 1][1]), cost[N - 1][2]));
	} // main
} // class
