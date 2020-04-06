import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2050_알파벳을숫자로변환 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();

		for (int i = 0; i < len; i++) {
			System.out.print((str.charAt(i) - 'A' + 1) + " ");
		}
	}
}
