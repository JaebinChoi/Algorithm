package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2985_세수 {
	static int A, B, C;
	static String result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		combination1();
		if (result == null) {
			combination2();
		}
		System.out.println(result);
	}

	private static void combination1() {
		if (A + B == C)
			result = A + "+" + B + "=" + C;
		else if (A - B == C)
			result = A + "-" + B + "=" + C;
		else if (A * B == C)
			result = A + "*" + B + "=" + C;
		else if (A / B == C)
			result = A + "/" + B + "=" + C;
	}

	private static void combination2() {
		if (A == B - C)
			result = A + "=" + B + "-" + C;
		if (A == B / C)
			result = A + "=" + B + "/" + C;
	}
}