package Icof.tree;
public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val > q.val) {
			TreeNode tmp = p;
			p = q;
			q = tmp;
		}
		while (root != null) {
			if (root.val < p.val) {
				root = root.right;
			} else if (root.val > q.val) {
				root = root.left;
			}
			else break;
		}
		return root;
	}
	public static void main(String[] args) {
		LowestCommonAncestor solution = new LowestCommonAncestor();
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(4);
		System.out.println(root.toString());
		TreeNode res = solution.lowestCommonAncestor(root, p, q);
		System.out.println(res.val);
	}
}