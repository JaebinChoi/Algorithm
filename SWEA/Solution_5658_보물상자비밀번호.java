import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5658_보물상자비밀번호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			String str = br.readLine();
			StringBuilder sb;

			LinkedList<Integer> queue = new LinkedList<>();
			for (int i = 0, size = n / 4; i < size; i++) { // 한 블록의 개수만큼
				sb = new StringBuilder();
				for (int j = 0; j < 4; j++) {
					int num = Integer.parseInt(str.substring(j * size, (j + 1) * size), 16);
					if (queue.contains(num))
						continue;
					queue.offer(num);
				}

				sb.append(str.charAt(str.length() - 1));
				sb.append(str.substring(0, str.length() - 1));
				str = sb.toString();
			}
			Collections.sort(queue);
			System.out.println("#" + tc + " " + queue.get(queue.size() - k));
		} // testcase
	} // main
} // class
