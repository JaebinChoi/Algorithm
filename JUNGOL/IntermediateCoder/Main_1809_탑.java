import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Main_1809_탑_최재빈 {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/test.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> idx_stack = new Stack<>();
		int[] idx = new int[N];

		for (int i = 0; i < N; i++) {
			int top = sc.nextInt();

			while (true) {
				// left = stack.peek(); // 왼쪽
				if (!stack.isEmpty() && stack.peek() < top) {	// 스택이 비어있지 않고, 왼쪽 탑이 기준 탑보다 작으면
					stack.pop();								// 왼쪽 탑을 스택에서 pop()
					idx_stack.pop();							// index 스택도 동일
					continue;									// 조건에서 벗어날 때까지
				}
				if (stack.isEmpty()) {							// 스택이 비어있다면
					idx[i] = 0;									// index는 0
					break;
				} else {										// 왼쪽 탑이 기준 탑보다 크면
					idx[i] = idx_stack.peek() + 1;				// index 스택에 쌓여있는 높은 탑의 인덱스 + 1(출력은 1부터)를 
					break;
				}

			}

			stack.push(top);									// 스택에 push()
			idx_stack.push(i);

		}
		for (int i : idx)
			System.out.print(i + " ");

	}
}
