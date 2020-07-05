package Icof.tree;

import java.util.LinkedList;
import java.util.Queue;
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		val = x;
	}
	public String toString() {
		TreeNode root = this;
		StringBuilder sb = new StringBuilder();
		if (root != null) {
			Queue<TreeNode> list = new LinkedList<>();
			list.add(root);
			TreeNode curNode;
			while (!list.isEmpty()) {
				curNode = list.remove();
				// System.out.print(curNode.val + " ");
				sb.append(curNode.val + " ");
				if (curNode.left != null) {
					list.add(curNode.left);
				}
				if (curNode.right != null) {
					list.add(curNode.right);
				}
			}
		}
		return sb.toString();
	}
}