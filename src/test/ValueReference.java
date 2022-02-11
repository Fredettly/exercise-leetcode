import java.util.Arrays;

/**
 * 值引用测试
 *
 * @author xwx
 * @since 2021/11/18
 */
public class ValueReference {
    static class obj {
        Integer a;
        public Integer getA() {
            return a;
        }
        public void setA(Integer a) {
            this.a = a;
        }
        public obj(Integer a) {
            this.a = a;
        }
        @Override
        public String toString() {
            return "obj{" +
                    "a=" + a +
                    '}';
        }
    }
    public static void main(String[] args) {
//        obj obj = new obj(1);
//        change(obj);
//        System.out.println(obj);
        int[] nums = {1, 2, 3};
        swap(nums, 0, 2);
        System.out.println(Arrays.toString(nums));
    }
    private static void change(obj value) {
        value.setA(123);
    }

    private static void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
