import java.util.Scanner;

public class Main_크로아티아 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String[] alpha = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		int cnt = 0;
		boolean flag = true;

		abc: while (flag) {
			for (int i = 0; i < alpha.length; i++) {
				int x = str.indexOf(alpha[i]);

				if (x > -1) {
					str = str.replaceFirst(alpha[i], " ");
					cnt++;
					continue abc;
				}
			}
			flag = false;
		}

		
		System.out.println(str.length());

	}
}