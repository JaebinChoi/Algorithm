package backjoon;

import java.util.Scanner;

public class Main_1547_공 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] haveBall = new boolean[4];
		haveBall[1] = true;

		for (int i = 0; i < n; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();

			boolean temp = haveBall[num1];
			haveBall[num1] = haveBall[num2];
			haveBall[num2] = temp;
		}
		
		for (int i = 1; i < 4; i++) {
			if (haveBall[i] == true) {
				System.out.println(i);
			}
		}
		
	}
}
