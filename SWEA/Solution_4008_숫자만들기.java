import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4008_숫자만들기 {
    static final int OP = 4;         // 사칙연산 개수
    static int N, max, min;          // 숫자 개수, 최대값, 최소값
    static int[] operators, numbers; // 연산자 배열, 숫자 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            operators = new int[OP];
            numbers = new int[N];
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < OP; i++) {
                operators[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            dfs(1, numbers[0]);
            System.out.println("#" + tc + " " + (max - min));
        }
    }

    /**
     * 모든 경우의 수로 연산을 수행해서 최대값과 최소값을 구하는 메소
     * cnt : 연산한 수의 개수
     * sum : 연산한 수의 합
     */
    private static void dfs(int cnt, int sum) {
        // 연산을 다 했을 경우
        if (cnt == N) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int op = 0; op < OP; op++) {
            // 해당 연산자를 다 사용한 경우
            if (operators[op] == 0) continue;
            --operators[op];
            switch (op) { // 연산 수행
                case 0: dfs(cnt + 1, sum + numbers[cnt]); break; // 덧셈
                case 1: dfs(cnt + 1, sum - numbers[cnt]); break; // 뺄셈
                case 2: dfs(cnt + 1, sum * numbers[cnt]); break; // 곱셈
                case 3: dfs(cnt + 1, sum / numbers[cnt]); break; // 나눗셈
            }
            ++operators[op];
        }
    }
}
