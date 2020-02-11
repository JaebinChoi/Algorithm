package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String str;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];
			int TH = 0;
			int TW = 0;
			char tank = ' ';

			for (int i = 0; i < H; i++) {
				str = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
						TH = i;
						TW = j;
						tank = map[i][j];
					}
				}
			}
			map[TH][TW] = '.';

			int N = Integer.parseInt(br.readLine());
			char[] input = new char[N];
			str = br.readLine();
			for (int i = 0; i < N; i++) {
				input[i] = str.charAt(i);
			}

			for (int i = 0; i < N; i++) {
				switch (input[i]) {
				case 'U':
					tank = '^';
					if (TH - 1 >= 0 && map[TH - 1][TW] != '#' && map[TH - 1][TW] != '-' && map[TH - 1][TW] != '*')
						TH--;
					break;
				case 'D':
					tank = 'v';
					if (TH + 1 < H && map[TH + 1][TW] != '#' && map[TH + 1][TW] != '-' && map[TH + 1][TW] != '*')
						TH++;
					break;
				case 'L':
					tank = '<';
					if (TW - 1 >= 0 && map[TH][TW - 1] != '#' && map[TH][TW - 1] != '-' && map[TH][TW - 1] != '*')
						TW--;
					break;
				case 'R':
					tank = '>';
					if (TW + 1 < W && map[TH][TW + 1] != '#' && map[TH][TW + 1] != '-' && map[TH][TW + 1] != '*')
						TW++;
					break;
				case 'S':
					if (tank == '^') {
						for (int j = TH - 1; j >= 0; j--) {
							if (map[j][TW] == '*') {
								map[j][TW] = '.';
								break;
							} else if (map[j][TW] == '#')
								break;
						}
					} else if (tank == 'v') {
						for (int j = TH + 1; j < H; j++) {
							if (map[j][TW] == '*') {
								map[j][TW] = '.';
								break;
							} else if (map[j][TW] == '#')
								break;
						}
					} else if (tank == '<') {
						for (int j = TW - 1; j >= 0; j--) {
							if (map[TH][j] == '*') {
								map[TH][j] = '.';
								break;
							} else if (map[TH][j] == '#')
								break;
						}
					} else {
						for (int j = TW + 1; j < W; j++) {
							if (map[TH][j] == '*') {
								map[TH][j] = '.';
								break;
							} else if (map[TH][j] == '#')
								break;
						}
					}
					break;
				}
			}

			map[TH][TW] = tank;
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		} // testcase

	}
}
