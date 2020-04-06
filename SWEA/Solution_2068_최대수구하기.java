import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_2068_최대수구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int max = Integer.MIN_VALUE;
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                max = max < num ? num : max;
            }
            System.out.println("#" + tc + " " + max);
        }
    }
}