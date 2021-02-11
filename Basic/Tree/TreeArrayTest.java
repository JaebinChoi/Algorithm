import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeArrayTest {
	static int index;
	static int[] tree;
	static int N;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/lecture/tree.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		// index를 이용해서 자식노드를 순회하기 때문에 0번은 사용 할 수 없다. 1 ~ N번까지 사용
		// 왼쪽자식 : index * 2 오른쪽자식 : index * 2 + 1
		tree = new int[N + 1];

		// 데이터 = 0 : 없는 데이터 데이터 > 0 : Node
		// 데이터가 0부터면 배열을 -1로 초기화 후 코딩(Arrays.fill?)
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}

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
	 * 트리를 중위(LVR)로 순회하는 함수
	 * @param index 현재 방문한 노드(vertex)의 index
	 */
	public static void inorder(int index) {
		// vertex가 경계 내에 있고, 데이터가 있다.
		if (index <= N && tree[index] != 0) {
			// 왼쪽 자식 방문		: vertex의 index * 2
			inorder(index << 1);
			// 현재 노드 처리
			System.out.print(tree[index] + " ");
			// 오른쪽 자식 방문		: vertex의 index * 2 + 1
			inorder((index << 1) + 1);
		}
	}
	
	/**
	 * 트리를 전위(VLR)로 순회하는 함수
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
