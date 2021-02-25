import java.io.*;

class Main_피라미드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 중심 축일 경우 = 1개
                if (j == n) System.out.print("*");
                // n - i(row) 만큼 공백 추가했으면 그 다음부터 ** (대칭이기때문에 2개)
                else if(j > n - i) System.out.print("**");
                else System.out.print(" ");
            }
            System.out.println("");
        }
    }
}