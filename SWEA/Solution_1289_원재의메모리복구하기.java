package swea;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution_1289_원재의메모리복구하기 {
	public static void main(String args[]) throws Exception {
		// Scanner sc = new Scanner(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		sc.nextLine();

		String input_bits;
		char bits[];
		int index;
		int count;
		boolean is_end;

		for (int test_case = 1; test_case <= T; test_case++) {

			input_bits = sc.nextLine();
			bits = new char[input_bits.length()];

			index = 0; // 값이 틀린 인덱스
			count = 0;
			is_end = true;

			for (int i = 0; i < input_bits.length(); i++)
				bits[i] = '0';

			while (is_end) {
				// 값이 틀린 인덱스 구하기
				for (int i = index; i < bits.length; i++) {
					if (bits[i] != input_bits.charAt(i)) {
						index = i;
						break;
					}

					if (i == bits.length - 1)
						is_end = false;
				}

				if (is_end == false)
					break;

				if (bits[index] == '1') {
					for (int i = index; i < bits.length; i++) {
						bits[i] = '0';
					}
				} else if (bits[index] == '0') {
					for (int i = index; i < bits.length; i++) {
						bits[i] = '1';
					}
				}

				count++;
				if (index == bits.length - 1)
					break;
				index += 1;
			}

			System.out.println("#" + test_case + " " + count);
		}
	}
}