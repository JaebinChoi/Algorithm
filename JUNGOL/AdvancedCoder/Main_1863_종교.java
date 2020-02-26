package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1863_종교 {
	static int[] parent;

	public static void makeSet(int v) {
		parent[v] = v;
	}

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
		System.setIn(new FileInputStream("res/종교.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		int count = 0;

		for (int tc = 0; tc < m; tc++) {
			line = br.readLine();
			st = new StringTokenizer(line);
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			if (parent[i] == 0)
				makeSet(i);
			if (parent[j] == 0)
				makeSet(j);

			union(i, j);
		}

		for (int idx = 1; idx < n; idx++) {
			if (parent[idx] == idx) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}
