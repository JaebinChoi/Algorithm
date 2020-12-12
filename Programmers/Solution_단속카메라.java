import java.util.Arrays;
import java.util.Comparator;

class Solution_단속카메라 {

	public int solution(int[][] routes) {
		int N = routes.length;
		int camera = 300001;
		int result = 1;

		Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});

		for (int i = 0; i < N; i++) {
			int in = routes[i][0];
			int out = routes[i][1];

			// 카메라 위치보다 다음 차량 진입 지점이 뒤에 있을 경우 카메라 1대 추가 설치
			if (camera < in) {
				camera = out;
				++result;
			} else {
				// 다음 차량의 진출 지점이 카메라 위치보다 앞이면 카메라 이동
				if (out < camera) {
					camera = out;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] routes = { { -20, 15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };

		System.out.println(new Solution_단속카메라().solution(routes));
	}
}