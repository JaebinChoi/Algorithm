import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * 현재 순열의 상태에서 크기순으로(사전순) 다음에 올 수 있는 순열을을 생성
 * 1. 시작순열 상태가 가장 작은 순열부터 시작
 * 2. 사용 후 np() 호출
 * 
 * 구형 알고리즘
 * 1. 뒤쪽부터 탐색하며 꼭대기(i) 찾기
 * 2. i - 1 위치에 교환할 큰 값(j) 찾기
 * 3. i - 1 위치, j 위치 값 교환
 * 4. i ~ 맨 뒤 교환하며 오름차순 정렬
 * 같은 숫자가 있을 경우 중복 제거
 *
 */
public class P03_NextPermutationTest {
	static int N;
	static int[] input;
	static int totalCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		// 시작 : 가장 작은 순열
		Arrays.sort(input);
		do {
			System.out.println(Arrays.toString(input));
		} while (nextPermutation());
		
		System.out.println("총 경우의 수 : " + totalCnt);
	}

	private static boolean nextPermutation() {
		totalCnt++;
		// step1
		int i = N - 1;
		while (i > 0 && input[i - 1] >= input[i]) // 작아지는 부분 찾기
			--i;
		if (i == 0) // 가장 큰 순열을 만들었을 경우
			return false;

		// step2
		int j = N - 1;
		while (input[i - 1] >= input[j])
			--j;

		// step3
		int temp = input[i - 1];
		input[i - 1] = input[j];
		input[j] = temp;

		// step4
		int k = N - 1;
		while (i < k) {
			temp = input[i];
			input[i] = input[k];
			input[k] = temp;
			++i;
			--k;
		}
		return true;
	}
}
