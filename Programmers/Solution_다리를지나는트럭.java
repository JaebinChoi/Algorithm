import java.util.LinkedList;

class Solution_다리를지나는트럭 {
	static int totalWeight;
	static LinkedList<Pos> queue;

	public class Pos {
		int time;
		int weight;

		public Pos(int time, int weight) {
			this.time = time;
			this.weight = weight;
		}
	}

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		queue = new LinkedList<Pos>();

		int time = 0;
		int idx = 0;
		while (true) {
			time++;

			// 도착한 트럭 제거
			while (true) {
				if (queue.isEmpty()) break;
				if (time - queue.peek().time == bridge_length) {
					totalWeight -= queue.poll().weight;
					continue;
				}
				break;
			}

			// 마지막 차량
			if (idx == truck_weights.length) {
				if(queue.isEmpty()) break; // 다리를 건넜다면
				continue;
			}
			
			// 가능한 무게
			if (totalWeight + truck_weights[idx] <= weight) {
				totalWeight += truck_weights[idx];
				queue.offer(new Pos(time, truck_weights[idx++]));
			}
		}

		return time;
	}

	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };

		System.out.println(new Solution_다리를지나는트럭().solution(bridge_length, weight, truck_weights));
	}
}