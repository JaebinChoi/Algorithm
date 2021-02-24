import java.io.*;
import java.util.StringTokenizer;

class Main_InsertionSort {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int depth = Integer.parseInt(br.readLine());
        // 2번째 원소부터 순회
        for (int i = 1; i <= depth; i++) {
            int cur = arr[i];
            int idx = i;

            // 앞의 원소들을 비교
            for (int j = i - 1; j >= 0; j--) {
                int pre = arr[j];
                // 현재 원소가 앞의 원소보다 작으면 위치 변경 및 인덱스 - 1
                if (cur < pre) {
                    swap(idx, j, arr);
                    --idx;
                }
            }
        }

        for (int i = 0, len = arr.length; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}