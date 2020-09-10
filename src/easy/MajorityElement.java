/**
 * Created by xwx_ on 2020/3/13
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int count = 1;
        int maj = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maj == nums[i])
                count++;
            else {
                count--;
                if (count == 0) {
                    maj = nums[i + 1];
                }
            }
        }
        return maj;
    }


    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int[] nums1 = {1, 2, 1, 3, 1, 4, 5, 5, 1};
        System.out.println(majorityElement(nums1));

    }
}
