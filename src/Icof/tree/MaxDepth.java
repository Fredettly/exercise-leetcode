package Icof.tree;
import java.lang.Math;
public class MaxDepth {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1;
	}
	public static void main(String[] args) {
		MaxDepth solution = new MaxDepth();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		int res = solution.maxDepth(root);
		System.out.println(res);
	}
}