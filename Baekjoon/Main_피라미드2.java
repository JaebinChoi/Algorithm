import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main_피라미드2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n > 50) return;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < (i * 2 + 1); j++) {
                System.out.print("*");
            }

            System.out.println("");
        }
    }
}