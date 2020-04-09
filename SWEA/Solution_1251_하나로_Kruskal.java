package algo0409;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 크루스칼 알고리즘 사용
public class Solution_1251_하나로_Kruskal {
	static Pos[] island;
	static int n;
	static double e;
	static int[] parents;
	static int[] rank;

	static class Pos {
		int x;
		int y;
		long weight;

		public Pos(int x, int y, long weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
	}

	static void makeSet(int x) {
		parents[x] = x;
	}

	static int findSet(int x) {
		if (x == parents[x])
			return x;
		else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (rank[px] > rank[py]) {
			parents[py] = px;
		} else {
			parents[px] = py;
			if (rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			island = new Pos[n];
			rank = new int[n];

			StringTokenizer stX = new StringTokenizer(br.readLine(), " ");
			StringTokenizer stY = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				island[i] = new Pos(Integer.parseInt(stX.nextToken()), Integer.parseInt(stY.nextToken()), 0);
			}

			e = Double.parseDouble(br.readLine());

			ArrayList<Pos> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					list.add(new Pos(i, j,
							(long) (Math.pow(island[i].x - island[j].x, 2) + Math.pow(island[i].y - island[j].y, 2))));
				}
			}

			Collections.sort(list, new Comparator<Pos>() {
				@Override
				public int compare(Pos o1, Pos o2) {
					return Long.compare(o1.weight, o2.weight);
				}
			});

			parents = new int[n];
			for (int i = 0; i < n; i++)
				makeSet(i);

			int cnt = 0;
			long result = 0;
			for (int i = 0, size = list.size(); i < size; i++) {
				int v1 = findSet(list.get(i).x);
				int v2 = findSet(list.get(i).y);
				if (v1 == v2)
					continue;

				union(v1, v2);

				result += list.get(i).weight;

				cnt++;
				if (cnt == n - 1)
					break;
			}

			System.out.println("#" + tc + " " + Math.round(result * e));
		}
	}
}
