package jungol;

/**
 * 
 * 구구단의 일부를 다음과 같이 출력하는 프로그램을 작성하시오. 곱셈의 결과는 오른쪽으로 맞추어 출력을 하고 결과값 사이의 공백은 3칸으로
 * 한다. 출력형식 예) 2_*_1_=__2___ (_는 공백을 나타내는 것임)​
 * 
 */
public class Main548 {
	public static void main(String[] args) {
		for (int i = 2; i < 5; i++) {
			for (int j = 1; j < 6; j++) {
				if (i * j < 10) {
					System.out.print(i + " * " + j + " =  " + (i * j) + "   ");
				} else {
					System.out.print(i + " * " + j + " = " + (i * j) + "   ");
				}

			}
			System.out.println();
		}
	}
}
