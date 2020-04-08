import java.util.Arrays;

/**
 * Created by xwx_ on 2020/2/28
 */
public class SearchInsert {
    public static int searchInsert(int [] nums, int target) {
        for(int i = 0 ; i < nums.length ; i++){
            if (nums[i] >= target)
                return i;
        }
        return nums.length;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,4,5};
        int target = 3;
        int res = searchInsert(nums, target);
        System.out.println(res);
    }
}
