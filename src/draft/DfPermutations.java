
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by xwx_ on 2020/4/27
 */
public class DfPermutations {
    public List<List<Integer>> permute(int[] nums) {
        //新建res数组列表
        List<List<Integer>> res = new ArrayList<>();
        //数组长度
        int len = nums.length;
        //特判
        if (len == 0) {
            return res;
        }
        //新建组合方法队列
        Deque<Integer> path = new ArrayDeque<>();
        //是否被用过
        boolean[] used = new boolean[len];
        //深度优先算法
        dfs(nums, res, len, 0, path, used);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int len, int depth, Deque<Integer> path, boolean[] used) {
        //定义回溯出口，深度等于数组长度时结束
        if (depth == len) {
            //每次结束前存入res数组列表
            res.add(new ArrayList<>(path));
            return;
        }
        //循环len层
        for (int i = 0; i < len; i++) {
            //用过的数跳过此次循环
            if (used[i]) {
                continue;
            }
            //组合队列加入当前数字
            path.addLast(nums[i]);
            //数字设为用过
            used[i] = true;
            //回溯
            dfs(nums, res, len, depth + 1, path, used);
            //移除前一个入队数字
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        DfPermutations solution = new DfPermutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = solution.permute(nums);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
