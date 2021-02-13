import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreeArrayTest3 {
	static int index;
	static int[] tree; // 트리 배열
	static int N;
	static int[] tmp; // 데이터를 입력 받을 배열

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/lecture/tree2.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		// index를 이용해서 자식노드를 순회하기 때문에 0번은 사용 할 수 없다. 1 ~ N번까지 사용
		// 왼쪽자식 : index * 2 오른쪽자식 : index * 2 + 1
		tree = new int[N + 1];
		tmp = new int[N];

		// 데이터 = 0 : 없는 데이터 데이터 > 0 : Node
		// 데이터가 0부터면 배열을 -1로 초기화 후 코딩(Arrays.fill?)
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			tmp[i] = Integer.parseInt(st.nextToken());
		}

		// 1. 정렬(sorting)
		Arrays.sort(tmp);

		insert(0, N);
		
		for (int i = 1; i <= N; i++) {
			System.out.print(tree[i] + " ");
		}
		System.out.println();

		// 중위순회
		System.out.println("<<<<<<<<<<<<<<< 중위 순회 >>>>>>>>>>>>>>>");
		inorder(1);
		System.out.println();

		// 전위순회
		System.out.println("<<<<<<<<<<<<<<< 전위 순회 >>>>>>>>>>>>>>>");
		preorder(1);
		System.out.println();

		// 후위순회
		System.out.println("<<<<<<<<<<<<<<< 후위 순회 >>>>>>>>>>>>>>>");
		postorder(1);
		System.out.println();

	}

	/**
	 * 2. 트리 구성하기
	 * 2-1. index(1), start(1), end(N) 중앙값 찾기 : (start + end) >> 1
	 * 2-2. 배열의 index번째에 중앙값을 저장
	 * 2-3. 왼쪽 자식 : index * 2, start, mid
	 * 2-4. 오른쪽 자식 : index * 2 + 1, mid + 1, end
	 */
	// full binary tree 아닐때도 가능
	public static void insert(int start, int end) {
		int mid = 0;
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {start, end});
		int idx = 1;
		int[] node;
		while(!queue.isEmpty()) {
			node = queue.poll();
			start = node[0];
			end = node[1];
			mid = middle(start, end);
			if(mid >= 0 && mid <= N && idx <= N && tmp[mid] != 0) {
				tree[idx++] = tmp[mid];
				tmp[mid] = 0;
				queue.offer(new int[] {start, mid});
				queue.offer(new int[] {mid + 1, end});
			}
		}
	}
	
	public static int middle(int start, int end) {
		return (start + end) >> 1;
	}

	/**
	 * 트리를 중위(LVR)로 순회하는 함수
	 * 
	 * @param index 현재 방문한 노드(vertex)의 index
	 */
	public static void inorder(int index) {
		// vertex가 경계 내에 있고, 데이터가 있다.
		if (index <= N && tree[index] != 0) {
			// 왼쪽 자식 방문 : vertex의 index * 2
			inorder(index << 1);
			// 현재 노드 처리
			System.out.print(tree[index] + " ");
			// 오른쪽 자식 방문 : vertex의 index * 2 + 1
			inorder((index << 1) + 1);
		}
	}

	/**
	 * 트리를 전위(VLR)로 순회하는 함수
	 * 
	 * @param index 현재 방문한 노드(vertex)의 index
	 */
	public static void preorder(int index) {
		// vertex가 경계 내에 있고, 데이터가 있다.
		if (index <= N && tree[index] != 0) {
			// 현재 노드 처리
			System.out.print(tree[index] + " ");
			// 왼쪽 자식 방문 : vertex의 index * 2
			preorder(index << 1);
			// 오른쪽 자식 방문 : vertex의 index * 2 + 1
			preorder((index << 1) + 1);
		}
	}

	/**
	 * 트리를 후위(LRV)로 순회하는 함수
	 * 
	 * @param index 현재 방문한 노드(vertex)의 index
	 */
	public static void postorder(int index) {
		// vertex가 경계 내에 있고, 데이터가 있다.
		if (index <= N && tree[index] != 0) {
			// 왼쪽 자식 방문 : vertex의 index * 2
			postorder(index << 1);
			// 오른쪽 자식 방문 : vertex의 index * 2 + 1
			postorder((index << 1) + 1);
			// 현재 노드 처리
			System.out.print(tree[index] + " ");
		}
	}
}
