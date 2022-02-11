package common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 *
 * @author xwx
 * @since 2021/11/18
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        if (!input.startsWith("[") || !input.endsWith("]")) {
            throw new RuntimeException("invalid input array!");
        }
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            throw new RuntimeException("null array!");
        }
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            if (index == parts.length) {
                break;
            }
            TreeNode node = nodeQueue.remove();
            item = parts[index++];
            item = item.trim();
            if (!"null".equalsIgnoreCase(item)) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
            if (index == parts.length) {
                break;
            }
            item = parts[index++];
            item = item.trim();
            if (!"null".equalsIgnoreCase(item)) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String treeNodeToString(TreeNode root) {
        Queue<TreeNode> list = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root != null) {
            list.add(root);
        }
        while (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                TreeNode treeNode = list.remove();
                if (treeNode == null) {
                    result.add(null);
                    continue;
                }
                result.add(treeNode.val);
                list.add(treeNode.left);
                list.add(treeNode.right);
            }
        }
        return result.toString();
    }
}