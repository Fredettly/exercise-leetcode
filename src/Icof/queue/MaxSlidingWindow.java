package Icof.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xwx_ on 2020/6/28
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1) {
            return new int[0];
            }
        int index = 0;
        Deque<Integer> max = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!max.isEmpty() && nums[max.peekLast()] <= nums[i]) {
                max.removeLast();
            }
            max.addLast(i);
            if (max.peekFirst() == i - k) {
                max.removeFirst();
            }
            if (i >= k - 1) {
                res[index++] = nums[max.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,4};
        int k = 2;
        int[] res = new MaxSlidingWindow().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
