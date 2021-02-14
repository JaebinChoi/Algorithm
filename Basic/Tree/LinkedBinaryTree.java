import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LinkedBinaryTree {
	TreeNode root;

	public TreeNode insertKey(TreeNode root, int x) {
		TreeNode p = root;
		TreeNode newNode = new TreeNode(x);

		if (p == null) {
			return newNode;
		} else if (p.data > x) {
			p.left = insertKey(p.left, x);
		} else if (p.data < x) {
			p.right = insertKey(p.right, x);
		}
		return p;

	}

	public void insertBST(int x) {
		root = insertKey(root, x);
	}

	public static final int PRE = 1;
	public static final int IN = 2;
	public static final int POST = 3;

	public void printBST(int method, TreeNode root) {
		switch (method) {
		case PRE:
			preorder(root);
			break;
		case IN:
			inorder(root);
			break;
		case POST:
			postorder(root);
			break;
		}
	}

	// 전위 (VLR)
	public void preorder(TreeNode node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}

	// 중위 (LVR)
	public void inorder(TreeNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}

	// 후위 (LRV)
	public void postorder(TreeNode node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data + " ");
		}
	}

	public TreeNode searchBST(int x) {
		TreeNode p = root;
		while (p != null) {
			if (x < p.data) {
				p = p.left;
			} else if (x > p.data) {
				p = p.right;
			} else { // 데이터 찾은 경우
				return p;
			}
		}
		return p; // 못 찾은 경우
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/lecture/tree.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		LinkedBinaryTree lbt = new LinkedBinaryTree();

		for (int i = 0; i < N; i++) {
			lbt.insertBST(Integer.parseInt(st.nextToken()));
		}

		TreeNode p1 = lbt.searchBST(4);
		if (p1 != null) {
			System.out.println(p1.data + " 탐색 성공");
			lbt.printBST(lbt.IN, p1);
		}
		System.out.println();

		p1 = lbt.searchBST(19);
		if (p1 != null) {
			System.out.println(p1.data + " 탐색 성공");
			lbt.printBST(lbt.IN, p1);
		} else {
			System.out.println("탐색 실패");
		}
		System.out.println();

		lbt.printBST(lbt.IN, lbt.root);
	}
}
