class Solution_키패드누르기 {
	static int[] number = { 2, 5, 8, 0 };
	static Pos left, right;
	static StringBuilder sb;

	class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public String solution(int[] numbers, String hand) {
		sb = new StringBuilder();
		left = new Pos(3, 0);
		right = new Pos(3, 2);

		for (int i = 0, size = numbers.length; i < size; i++)
			move(numbers[i], hand);

		return sb.toString();
	}

	private void move(int num, String hand) {
		if (num == 0 || num % 3 == 2) { 							// 2, 5, 8, 0
			for (int i = 0, size = number.length; i < size; i++) { 	// 2, 5, 8, 0 순회
				if (number[i] == num) { 							// 해당 숫자를 찾은 경우
					int leftDistance = Math.abs(left.r - i) + Math.abs(left.c - 1);
					int rightDistance = Math.abs(right.r - i) + Math.abs(right.c - 1);

					if (leftDistance < rightDistance) setLeft(i, 1);
					else if (leftDistance > rightDistance) setRight(i, 1);
					else {
						if (hand.equals("left")) setLeft(i, 1);
						else setRight(i, 1);
					}
					break;
				}
			}
		}
		else if (num % 3 == 1) setLeft(num / 3, 0); 		// 1, 4, 7
		else if (num % 3 == 0) setRight(num / 3 - 1, 2); 	// 3, 6, 9
	}

	private void setLeft(int r, int c) {
		sb.append('L');
		left.r = r;
		left.c = c;
	}

	private void setRight(int r, int c) {
		sb.append('R');
		right.r = r;
		right.c = c;
	}
	
	public static void main(String[] args) {
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";

		System.out.println(new Solution_키패드누르기().solution(numbers, hand));
	}
}