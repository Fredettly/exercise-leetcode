package Icof.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class LevelOrderIII {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> list = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();
		if (root != null) {
			list.add(root);
		}
		while (!list.isEmpty()) {
			LinkedList<Integer> tmp = new LinkedList<>();
			for (int i = list.size(); i > 0; i--) {
				TreeNode node = list.remove();
				if ((res.size() & 1) == 0) {
					tmp.addLast(node.val);
				} else {
					tmp.addFirst(node.val);
				}
				if (node.left != null) {
					list.add(node.left);
				}
				if (node.right != null) {
					list.add(node.right);
				}
			}
			res.add(tmp);
		}
		return res;
	}
	public static void main(String[] args) {
		LevelOrderIII solution = new LevelOrderIII();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> res = solution.levelOrder(root);
		for (List<Integer> l : res) {
			System.out.println(l);
		}
	}
}