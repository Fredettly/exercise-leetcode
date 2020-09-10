package Icof.tree;


import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.List;
public class LevelOrderII {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> list = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();
		if (root != null) {
			list.add(root);
		}
		while (!list.isEmpty()) {
			List<Integer> tmp = new ArrayList<>();
			for (int i = list.size(); i > 0; i--) {
				TreeNode node = list.remove();
				tmp.add(node.val);
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
		LevelOrderII solution = new LevelOrderII();
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