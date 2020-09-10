package Icof.tree;

/**
	剑指 Offer 32 - I. 从上到下打印二叉树

	从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

	例如:
	给定二叉树: [3,9,20,null,null,15,7],

	    3
	   / \
	  9  20
	    /  \
	   15   7
	返回：

	[3,9,20,15,7]

*/

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.List;
public class LevelOrderI {
	public int[] levelOrder(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		Queue<TreeNode> list = new LinkedList<>();
		List<Integer> arr = new ArrayList<>();
		list.add(root);
		while (!list.isEmpty()) {
			TreeNode node = list.remove();
			arr.add(node.val);
			if (node.left != null) {
				list.add(node.left);
			}
			if (node.right != null) {
				list.add(node.right);
			}
		}
		int[] res = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			res[i] = arr.get(i);
		}
		return res;
	}

	public static void main(String[] args) {
		LevelOrderI solution = new LevelOrderI();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		int[] res = solution.levelOrder(root);
		System.out.println(Arrays.toString(res));
	}
}