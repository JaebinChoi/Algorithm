import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	static int M, A;
	static BC[] bc;
	static User userA, userB;
	static int[] moveA, moveB;
	static int[][] dir = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static class User {
		int x;
		int y;

		public User(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class BC implements Comparable<BC> {
		int x;
		int y;
		int idx;
		int coverage;
		int performance;

		public BC() {
		}

		public BC(int x, int y, int idx, int coverage, int performance) {
			this.x = x;
			this.y = y;
			this.idx = idx;
			this.coverage = coverage;
			this.performance = performance;
		}

		@Override
		public int compareTo(BC o) {
			return Integer.compare(this.performance, o.performance);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()); // 이동 거리
			A = Integer.parseInt(st.nextToken()); // BC 개수

			moveA = new int[M + 1]; // A 이동 정보
			moveB = new int[M + 1]; // B 이동 정보
			StringTokenizer infoA = new StringTokenizer(br.readLine(), " ");
			StringTokenizer infoB = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= M; i++) {
				moveA[i] = Integer.parseInt(infoA.nextToken());
				moveB[i] = Integer.parseInt(infoB.nextToken());
			}

			bc = new BC[A + 1]; // BC 정보
			for (int i = 1; i <= A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				bc[i] = new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i,
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			userA = new User(1, 1);
			userB = new User(10, 10);

			int sum = 0;
			for (int i = 0; i <= M; i++)
				sum += Action(i);

			System.out.println("#" + tc + " " + sum);
		} // testcase
	} // main

	private static int Action(int i) {
		LinkedList<BC> queueA = new LinkedList<>();
		LinkedList<BC> queueB = new LinkedList<>();

		userA = move(userA, i, moveA);
		userB = move(userB, i, moveB);

		queueA.offer(new BC());
		queueB.offer(new BC());

		for (int j = 1; j <= A; j++) {
			if (isRange(userA, bc[j]))
				queueA.offer(bc[j]);

			if (isRange(userB, bc[j]))
				queueB.offer(bc[j]);
		}

		queueA = sort(queueA);
		queueB = sort(queueB);

		// 속한 BC가 같으면
		if (queueA.get(0).idx == queueB.get(0).idx) {
			if (queueA.size() == 1 && queueB.size() == 1) // 둘다 속한 BC가 없음
				return 0;
			else if (queueA.size() == 1) // A가 1개이면 B가 속한 다음 BC를 이용
				queueB.poll();
			else if (queueB.size() == 1) // B가 1개이면 A가 속한 다음 BC를 이용
				queueA.poll();
			else { // A,B가 속한 BC 개수가 2개 이상 => 다음 BC의 성능이 더 높은 것을 이용
				if (queueA.get(1).performance > queueB.get(1).performance)
					queueA.remove(0);
				else
					queueB.remove(0);
			}
		}
		return queueA.get(0).performance + queueB.get(0).performance;
	}

	private static LinkedList<BC> sort(LinkedList<BC> queue) {
		Collections.sort(queue);
		Collections.reverse(queue);
		return queue;
	}

	private static boolean isRange(User user, BC bc) {
		int distance = Math.abs(user.x - bc.x) + Math.abs(user.y - bc.y);
		return distance <= bc.coverage ? true : false;
	}

	private static User move(User user, int i, int[] move) {
		user.x += dir[move[i]][1];
		user.y += dir[move[i]][0];
		return user;
	}
} // class