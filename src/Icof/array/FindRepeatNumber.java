package Icof.array;

import java.util.HashSet;

/**
 * 数组中重复的数字
 */

public class FindRepeatNumber {

    private HashSet<Integer> set;
    private int res = -1;

    public int findRepeatNumber(int[] nums) {
    	set = new HashSet<>();
    	for (int num : nums) {
    		if (!set.add(num)) {
    			res = num;
    		}
    	}
    	return res;
    }


    public static void main(String[] args) {
    	int[] nums = {2, 3, 1, 0, 2, 5, 3};
    	FindRepeatNumber solution = new FindRepeatNumber();
    	int res = solution.findRepeatNumber(nums);
    	System.out.println(res);
    }


}
