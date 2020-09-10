package Icof.tree;
public class KthLargest {
	private int ans = 0;
	private int count = 0;
	public int kthLargest(TreeNode root, int k) {
		helper(root, k);
		return ans;
	}
	public void helper(TreeNode root, int k) {
		if (root.right != null) {
			helper(root.right, k);
		}
		if (++count == k) {
			ans = root.val;
		}
		if (root.left != null) {
			helper(root.left, k);
		}
	}
	public static void main(String[] args) {
		KthLargest solution = new KthLargest();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		int res = solution.kthLargest(root, 1);
		System.out.println(res);
	}
}