package jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1863_종교 {
	static int[] parent;

	public static int findSet(int v) {
		if (parent[v] == v) { // root인지 검사
			return v;
		}
		// findSet(parent[v]) => root를 찾음
		parent[v] = findSet(parent[v]); // => path compression
		return parent[v];
	}

	public static void union(int u, int v) {
		// 두 그래프 중 아무 그래프에 병합하면 편향트리가 될 수 있다. => path compression
		parent[findSet(u)] = findSet(v);
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/종교.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);

		int n = Integer.parseInt(st.nextToken()); // 학생 수
		int m = Integer.parseInt(st.nextToken()); // 쌍의 수

		parent = new int[n + 1]; // 부모를 나타내는 배열
		int count = 0;

		// 각 인덱스의 부모를 본인으로 설정
		for (int idx = 1; idx <= n; idx++) {
			parent[idx] = idx;
		}

		for (int tc = 0; tc < m; tc++) {
			line = br.readLine();
			st = new StringTokenizer(line);

			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			// 큰 수의 부모를 작은 수로 설정
			if (i < j)
				union(j, i);
			else
				union(i, j);

		}

		// 본인이 부모인 개수 파악
		for (int idx = 1; idx < n + 1; idx++) {
			if (parent[idx] == idx) {
				count++;
			}
		}

		// 쌍이 없으면 종교 수는 학생 수
		if (m == 0) {
			count = n;
		}

		System.out.println(count);

	}
}
