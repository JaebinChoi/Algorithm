import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_SelectionSort {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        // 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // i 번째 원소를 기준으로 배열을 순회하며 최소값 찾기
        for (int i = 0; i < s; i++) {
            int idx = i;
            int min = arr[i];

            for (int j = i + 1, len = arr.length; j < len; j++) {
                int next = arr[j];

                // 현재 최소값보다 작은 값이 있으면 변경
                if (next < min) {
                    min = next;
                    idx = j;
                }
            }

            // 현재 위치와 최소 값의 위치를 바꿔줌
            swap(idx, i, arr);
        }

        // 출력
        for (int i = 0, len = arr.length; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 원소의 위치를 바꾸는 메소드
    private static void swap(int x, int y, int[] arr) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}