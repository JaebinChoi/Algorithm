import java.util.Arrays;

class Solution_전화번호목록 {
	public boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);
		System.out.println(Arrays.toString(phone_book));

		for (int i = 0, size = phone_book.length; i < size - 1; i++) {
			String phone = phone_book[i];

			// 해당 문자열의 길이가 다음 문자열의 길이보다 길면 런타임
			if (phone.length() > phone_book[i + 1].length()) continue;
			
			// 해당 문자열이 다음 문자열의 접두사가 아니면 continue
			if (!phone_book[i + 1].substring(0, phone.length()).equals(phone)) continue;
			
			// 접두사가 맞으면
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		String[] phone_book = { "119", "97674223", "1195524421" };

		new Solution_전화번호목록().solution(phone_book);
	}
}