class Solution_키패드누르기_풀이참고 {
	static int leftHand = 10;
	static int rightHand = 12;
	static StringBuilder sb;

	public String solution(int[] numbers, String hand) {
		sb = new StringBuilder();

		for (int i = 0, size = numbers.length; i < size; i++)
			move(numbers[i], hand);

		return sb.toString();
	}

	// 손가락을 움직이는 메소드
	private void move(int number, String hand) {
		if (number == 1 || number == 4 || number == 7) leftHand = number;
		else if (number == 3 || number == 6 || number == 9) rightHand = number;
		else {
			int leftDistance = getDistance(leftHand, number);
			int rightDistance = getDistance(rightHand, number);

			if (leftDistance < rightDistance) leftHand = number;
			else if (leftDistance > rightDistance) rightHand = number;
			else {
				if (hand.equals("left")) leftHand = number;
				else rightHand = number;
			}
		}

		if (leftHand == number) sb.append('L');
		else sb.append('R');
	}

	// 거리를 구하는 메소드
	private int getDistance(int departure, int destination) {
		if (destination == 0) destination = 11;
		if (departure == 0) departure = 11;

		int fromRow = (departure - 1) / 3;
		int fromCol = (departure - 1) % 3;

		int toRow = (destination - 1) / 3;
		int toCol = (destination - 1) % 3;

		return Math.abs(fromRow - toRow) + Math.abs(fromCol - toCol);
	}

	public static void main(String[] args) {
		int[] numbers = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
		String hand = "left";

		System.out.println(new Solution_키패드누르기_풀이참고().solution(numbers, hand));
	}
}