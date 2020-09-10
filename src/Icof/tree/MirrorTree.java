package Icof.tree;


public class MirrorTree {
	public TreeNode mirrorTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode tmp = root.left;
		root.left = mirrorTree(root.right);
		root.right = mirrorTree(tmp);
		return root;
	}
	public static void main(String[] args) {
		MirrorTree solution = new MirrorTree();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		System.out.println(root.toString());
		TreeNode res = solution.mirrorTree(root);
		System.out.println(res.toString());
	}
}