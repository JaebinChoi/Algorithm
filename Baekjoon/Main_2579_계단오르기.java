package algo0416;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2579_계단오르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[301];

		for (int i = 1; i <= N; i++)
			stairs[i] = Integer.parseInt(br.readLine());

		int[] scores = new int[301];
		scores[1] = stairs[1];
		scores[2] = stairs[2] + stairs[1];

		for (int i = 3; i <= N; i++) {
			// 한칸 오른 것은 한칸 오르기 전 2칸 전에서 올라왔다라는 것이 중요!
			scores[i] = Math.max(stairs[i] + stairs[i - 1] + scores[i - 3], stairs[i] + scores[i - 2]); // 한칸 vs 두칸
		}
		sb.append(scores[N]);
		System.out.println(sb.toString());
	}
}
