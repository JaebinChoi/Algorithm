package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 쇠막대기
public class Main_2858 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		int count = 0;
		int result = 0;

		String line = br.readLine();

		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);

			if (ch == '(') {
				count++;
			} else {
				if (stack.peek() == '(') {
					result += --count;
				} else {
					count--;
					result++;
				}
			}
			stack.push(ch);
		}
		System.out.println(result);
	}
}