package Icof.tree;
import java.lang.Math;
public class IsBalanced {

	public boolean isBalanced(TreeNode root) {
		return helper(root) != -1;
	}

	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left);
		if (left == -1) {
			return -1;
		}
		int right = helper(root.right);
		if (right == -1) {
			return -1;
		}
		return Math.abs(left - right) < 2 ? Math.max(left , right) + 1 : -1;
	}

	public static void main(String[] args) {
		IsBalanced solution = new IsBalanced();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(6);
		System.out.println(solution.isBalanced(root));
	}
}