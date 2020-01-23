import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xwx_ on 2020/1/21
 */
public class Two_Sum {

    //     static int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == target - nums[i]) {
//                    return new int[] { i, j };
//                }
//            }
//        }
//        throw new RuntimeException("No two sum solution");
//    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>((int) ((float) nums.length / 0.75F + 1.0F));
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum value");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 26;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
