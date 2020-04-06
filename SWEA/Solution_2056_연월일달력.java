import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2056_연월일달력 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String calendar = br.readLine();
			String sYear = calendar.substring(0, 4);
			String sMonth = calendar.substring(4, 6);
			String sDay = calendar.substring(6, 8);
			int year = Integer.parseInt(sYear);
			int month = Integer.parseInt(sMonth);
			int day = Integer.parseInt(sDay);

			boolean flag = false;

			if (month > 0 && month < 13) {
				if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
					if (day < 32 && day > 0) {
						flag = true;
					}
				} else {
					if (month == 2) {
						if (day < 29 && day > 0) {
							flag = true;
						}
					} else {
						if (day < 31 && day > 0) {
							flag = true;
						}
					}
				}
			}

			System.out.println("#" + tc + " " + (flag ? sYear + "/" + sMonth + "/" + sDay : -1));
		}
	}
}
