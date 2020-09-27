import java.util.ArrayList;

class Solution_프렌즈4블록 {
	static int R, C, result;
	static char[][] map;
	static int[][] dir = { { 0, 1 }, { 1, 1 }, { 1, 0 } };
	static ArrayList<int[]> pop = new ArrayList<>();
	static int[] count;

	public int solution(int m, int n, String[] board) {
		map = new char[m][n];
		R = m;
		C = n;
		count = new int[C];

		for (int i = 0; i < R; i++)
			map[i] = board[i].toCharArray();

		while (true) {
			int same = 0;
			pop.clear();

			// 순회하며 4블록 형성 되는지 확인
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 'X') continue;
					if (find(i, j)) same++;
				}
			}
			if (same == 0) break;
			
			for (int[] pos : pop) { 						// 4블록 형성되어 있는 부분을 X로
				if (map[pos[0]][pos[1]] == 'X') continue; 	// 이미 X이면 패스
				count[pos[1]]++; 							// 열 단위로 지워진 블록 개수 저장
				result++; 									// 전체 터지는 개수 저장
				map[pos[0]][pos[1]] = 'X';
			}

			for (int c = 0; c < C; c++) { 					// 지워진 블록이 있으면 빈 공간을 채움
				if (count[c] > 0) move(c, count[c]);
			}
		}

		return result;
	}

	// 빈 공간을 채우는 메소드
	private void move(int c, int cnt) {
		int idx = R - 1;
		for (int r = R - 1; r >= 0; r--) {
			if (map[r][c] != 'X') {
				map[idx][c] = map[r][c];
				idx--;
			}
		}

		for (int i = 0; i < cnt; i++)
			map[i][c] = 'X';
	}

	// 4블록이 형성되는지 확인하는 메소드
	private boolean find(int r, int c) {
		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[] { r, c });

		for (int i = 0; i < 3; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];

			if (!isIn(nr, nc) || map[r][c] != map[nr][nc])
				return false;
			list.add(new int[] { nr, nc });
		}

		pop.addAll(list);
		return true;
	}

	private boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < R && nc < C;
	}

	public static void main(String[] args) {
		int m = 6;
		int n = 6;
		String[] board = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" };

		System.out.println(new Solution_프렌즈4블록().solution(m, n, board));
	}
}