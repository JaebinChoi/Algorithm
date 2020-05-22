import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {
	static final int MAGNUM = 4; // 자석 개수
	static final int TOOTHNUM = 8; // 톱니 개수
	static int K;
	static LinkedList<Integer>[] magnet; // 1 : N 0 : S
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(br.readLine());

			magnet = new LinkedList[MAGNUM + 1];
			for (int i = 1; i <= MAGNUM; i++)
				magnet[i] = new LinkedList<>();

			// 자석 정보 입력
			for (int i = 1; i <= MAGNUM; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < TOOTHNUM; j++) {
					magnet[i].offer(Integer.parseInt(st.nextToken()));
				}
			}

			// 회전
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int magIdx = Integer.parseInt(st.nextToken()); // 회전시킬 자석
				int dir = Integer.parseInt(st.nextToken()); // 회전방향
				
				visited = new boolean[MAGNUM + 1];
				rotation(magIdx, dir);
			}
			
			int sum = 0;
			for (int i = 1; i <= MAGNUM; i++)
				sum += Math.pow(2, i - 1) * magnet[i].get(0);

			System.out.println("#" + tc + " " + sum);
		} // testcase
	} // main

	// 회전
	private static void rotation(int magIdx, int dir) {
		visited[magIdx] = true;

		if (dir == 1) { // 시계방향
			if(isAble(magIdx, "Right")) rotation(magIdx + 1, 0);
			if(isAble(magIdx, "Left"))  rotation(magIdx - 1, 0);
			rotationRight(magIdx);
		} else { // 반시계방향
			if(isAble(magIdx, "Right")) rotation(magIdx + 1, 1);
			if(isAble(magIdx, "Left"))  rotation(magIdx - 1, 1);
			rotationLeft(magIdx);
		}
	}

	private static boolean isAble(int magIdx, String motion) {
		if(motion.equals("Right")) {
			// 오른쪽 자석 작업
			if (isIn(magIdx + 1) && !visited[magIdx + 1]) {
				// 극이 다르면 회전
				if (magnet[magIdx].get(2) != magnet[magIdx + 1].get(6))
					return true;
			}
		} else {
			// 왼쪽 자석 작업
			if (isIn(magIdx - 1) && !visited[magIdx - 1]) {
				// 극이 다르면 회전
				if (magnet[magIdx].get(6) != magnet[magIdx - 1].get(2))
					return true;
			}
		}
		return false;
	}

	// 반시계방향 회전
	private static void rotationLeft(int idx) {
		magnet[idx].offerLast(magnet[idx].pollFirst());
	}

	// 시계방향 회전
	private static void rotationRight(int idx) {
		magnet[idx].offerFirst(magnet[idx].pollLast());
	}

	private static boolean isIn(int idx) {
		return idx > 0 && idx <= MAGNUM;
	}
} // class