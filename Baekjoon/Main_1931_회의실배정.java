package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1931_회의실배정 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/회의실배정.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] rooms = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			rooms[i][0] = Integer.parseInt(st.nextToken());
			rooms[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(rooms, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});

		int boundary = rooms[0][1];
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			// 회의시간이 곂칠 경우
			if (rooms[i][0] < boundary)
				continue;
			else {
				boundary = rooms[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
