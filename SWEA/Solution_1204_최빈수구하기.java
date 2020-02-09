package swea;
import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int index = sc.nextInt();
             
            int score[] = new int[1001];
            int score_count[] = new int[101];
            int fre = 0;
            int max = 0;
 
            for (int i = 1; i < 1001; i++) {
                score[i] = sc.nextInt();
                score_count[score[i]] += 1;
            }
 
            fre = score_count[1];
            for (int j = 2; j < 101; j++) {
                if (score_count[j] >= fre) {
                    fre = score_count[j];
                    max = j;
                }
            }
 
            System.out.println("#" + index + " " + max);
        }
 
    }
}