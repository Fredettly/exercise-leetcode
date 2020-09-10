package Icof.tree;

public class IsSymmetric {

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root.left, root.right);
	}

	private boolean helper(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
	}

	public static void main(String[] args) {
		IsSymmetric solution = new IsSymmetric();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		System.out.println(root.toString());
		System.out.println(solution.isSymmetric(root));
	}
}