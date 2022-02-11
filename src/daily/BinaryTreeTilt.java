package daily;

import common.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 563. 二叉树的坡度
 *
 * 给定一个二叉树，计算 整个树 的坡度 。
 *
 * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。
 *
 * 如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
 *
 * 整个树 的坡度就是其所有节点的坡度之和。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3]
 * 输出：1
 * 解释：
 * 节点 2 的坡度：|0-0| = 0（没有子节点）
 * 节点 3 的坡度：|0-0| = 0（没有子节点）
 * 节点 1 的坡度：|2-3| = 1（左子树就是左子节点，所以和是 2 ；右子树就是右子节点，所以和是 3 ）
 * 坡度总和：0 + 0 + 1 = 1
 * 示例 2：
 *
 *
 * 输入：root = [4,2,9,3,5,null,7]
 * 输出：15
 * 解释：
 * 节点 3 的坡度：|0-0| = 0（没有子节点）
 * 节点 5 的坡度：|0-0| = 0（没有子节点）
 * 节点 7 的坡度：|0-0| = 0（没有子节点）
 * 节点 2 的坡度：|3-5| = 2（左子树就是左子节点，所以和是 3 ；右子树就是右子节点，所以和是 5 ）
 * 节点 9 的坡度：|0-7| = 7（没有左子树，所以和是 0 ；右子树正好是右子节点，所以和是 7 ）
 * 节点 4 的坡度：|(3+5+2)-(9+7)| = |10-16| = 6（左子树值为 3、5 和 2 ，和是 10 ；右子树值为 9 和 7 ，和是 16 ）
 * 坡度总和：0 + 0 + 0 + 2 + 7 + 6 = 15
 * 示例 3：
 *
 *
 * 输入：root = [21,7,14,1,1,2,2,3,3]
 * 输出：9
 *
 * @author xwx
 * @since 2021/11/18
 *
 */
public class BinaryTreeTilt {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = TreeNode.stringToTreeNode(line);
            System.out.println(findTilt2(root));
            ans = 0;
        }
    }

    /**
     * 递归 1.0
     *
     * 时间复杂度：每个节点被访问的次数与其所在深度有关。复杂度为 O(n^2)
     * 空间复杂度：忽略递归来带的额外空间消耗。复杂度为 O(1)
     *
     * @param root 二叉树
     * @return 坡度
     */
    private static int findTilt1(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return findTilt1(root.left) + findTilt1(root.right) + Math.abs(getSum1(root.left) - getSum1(root.right));
    }

    private static int getSum1(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return getSum1(root.left) + getSum1(root.right) + root.val;
    }

    /**
     * 递归 2.0
     *
     * 计算子树权值和的时候将坡度进行累加，从而将复杂度降为 O(n)
     *
     * @param root 二叉树
     * @return 坡度
     */
    static int ans;

    private static int findTilt2(TreeNode root) {
        dfs(root);
        return ans;
    }

    private static int dfs(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int l = dfs(root.left), r = dfs(root.right);
        ans += Math.abs(l - r);
        return l + r + root.val;
    }
}
