import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution_1218_괄호짝짓기 {
	static final String open = "([{<";
	static final String close = ")]}>";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			String line = br.readLine();
			ArrayDeque<Character> stack = new ArrayDeque<>();
			boolean flag = true;

			for (int i = 0; i < n; i++) {
				char ch = line.charAt(i);

				// 열린괄호
				if (open.indexOf(ch) > -1)
					stack.push(ch);

				// 닫힌괄호
				if (close.indexOf(ch) > -1) {
					char comp = stack.peek();
					if (close.indexOf(ch) == open.indexOf(comp))
						stack.pop();
					else
						flag = false;
				}

				if (!flag)
					break;
			}
			System.out.println("#" + tc + " " + (flag ? 1 : 0));
		}
	}
}
