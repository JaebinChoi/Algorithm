import java.util.Scanner;

public class Solution_2019_더블더블 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num = 1;
		for (int i = 1; i <= n + 1; i++) {
			System.out.print(num + " ");
			num *= 2;
		}
	}
}
