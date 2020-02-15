package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1697 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			char command = st.nextToken().charAt(0);

			if (st.countTokens() == 0) {
				if (command == 'o') {
					if (queue.isEmpty())
						System.out.println("empty");
					else
						System.out.println(queue.poll());
				} else
					System.out.println(queue.size());
			} else {
				int num = Integer.parseInt(st.nextToken());
				queue.offer(num);
			}
		}

	}
}
