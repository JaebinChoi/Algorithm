package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1863_종교 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 학생 수
		int m = Integer.parseInt(st.nextToken()); // 쌍의 수
		int[][] arr = new int[m][2]; // 쌍 배열
		ArrayList<Integer> list[] = new ArrayList[n * 10];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		int arr_idx = 0;
		for (int i = 0; i < m; i++) {
			if (list[arr_idx] == null) { // 리스트가 비어 있으면 둘 다 추가 .isEmpty()
				list[arr_idx] = new ArrayList<>();
				list[arr_idx].add(arr[i][0]);
				list[arr_idx].add(arr[i][1]);
				continue;
			}

			boolean front = false; // 앞 친구가 리스트에 있는지 여부
			int front_idx = -1; // 친구가 속해있는 리스트 인덱스
			for (int j = 0; j <= arr_idx; j++) {
				if (list[j].contains(arr[i][0])) { // 리스트에 앞 친구가 들어있을 때
					front = true;
					front_idx = j;
				}
			}

			boolean back = false;
			int back_idx = -1;
			for (int j = 0; j <= arr_idx; j++) {
				if (list[j].contains(arr[i][1])) { // 리스트에 뒷 친구가 들어있을 때
					back = true;
					back_idx = j;
				}
			}

			if (front && back) { // 둘다 리스트에 있을 때
				if (front_idx != back_idx) { // 리스트 인덱스가 다르면
					int min = Math.min(front_idx, back_idx);
					int max = Math.max(front_idx, back_idx);
					list[min].addAll(list[max]); // 작은 인덱스 배열에 큰 인덱스 배열에 있는 원소를 모두 옮김

					for (int j = max; j < arr_idx; j++) { // 비어있는 큰 인덱스 배열을 덮어 씌우기 위해 한칸씩 덮어쓰기
						list[j].addAll(list[j + 1]);
					}

					arr_idx--; // 배열 사이즈 -1
					continue;
				}
			} else if (front && !back) { // 앞은 리스트에 있고 뒤는 없을 때
				list[front_idx].add(arr[i][1]);
			} else if (!front && back) { // 뒤는 리스트에 있고 앞은 없을 때
				list[back_idx].add(arr[i][0]);
			} else { // 둘다 리스트에 없을 때
				list[++arr_idx] = new ArrayList<>();
				list[arr_idx].add(arr[i][0]);
				list[arr_idx].add(arr[i][1]);
			}

		} // m 만큼 반복

		if (m == 0)
			arr_idx = n - 1;

		System.out.println(arr_idx + 1);

	}
}
