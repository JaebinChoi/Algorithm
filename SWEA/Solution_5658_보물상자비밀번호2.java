import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_5658_보물상자비밀번호2 {
    static final int SQUARE = 4; // 4개의 변

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // N개의 숫자
            int K = Integer.parseInt(st.nextToken());   // K 번째로 큰 수
            StringBuilder number = new StringBuilder(br.readLine());
            HashSet<String> set = new HashSet<>();
            int lineNumCnt = N / 4;                     // 한 변의 숫자 개수

            for (int i = 0; i < lineNumCnt; i++) {      // 한 변에 있는 숫자 개수만큼 반복
                for (int j = 0; j < SQUARE; j++) {      // 숫자를 4개로 나눔 (사각형의 변 = 4개)
                    set.add(number.substring(j * lineNumCnt, (j + 1) * lineNumCnt));
                }
                number.deleteCharAt(0).append(number.charAt(0)); // 첫 번째 숫자를 떼서 뒤에 붙임
            }

            ArrayList<Integer> numberArray = new ArrayList<>();  // 10진수 리스트
            Iterator<String> iterator = set.iterator();          // 16진수 순회

            while (iterator.hasNext()) {
                int num = Integer.parseInt(iterator.next(), 16); // 16진수 -> 10진수
                numberArray.add(num);
            }

            Collections.sort(numberArray, new Comparator<Integer>() { // 내림차순 정렬
                @Override
                public int compare(Integer o1, Integer o2) {
                    return -1 * Integer.compare(o1, o2);
                }
            });

            System.out.println("#" + tc + " " + numberArray.get(K - 1));
        }
    }
}
