package acm;

/**
 * @Author: xwx
 * @DateTime: 2021/8/13
 * @Description: 百钱买百鸡
 * 鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？————《算经》
 */
public class HundredMoneyHundredChicken {
    /**
     * O(n^3)
     */
    public static void method1() {
        int count = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                for (int k = 0; k <= 100; k += 3) {
                    count++;
                    if (i * 5 + j * 3 + k / 3 == 100 && i + j + k == 100) {
                        System.out.println("公鸡=" + i + " 母鸡=" + j + " 小鸡=" + k);
                    }
                }
            }
        }
        System.out.println("循环次数=" + count);
    }

    /**
     * O(n^2)
     */
    public static void method2() {
        int count = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                count++;
                int k = 100 - i - j;
                if (k % 3 == 0 && i * 5 + j * 3 + k / 3 == 100 && i + j + k == 100) {
                    System.out.println("公鸡=" + i + " 母鸡=" + j + " 小鸡=" + k);
                }
            }
        }
        System.out.println("循环次数=" + count);
    }

    /**
     * 限制枚举范围
     * 遍历次数 = 20 * 33
     */
    public static void method3() {
        int count = 0;
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 33; j++) {
                count++;
                int k = 100 - i - j;
                if (k % 3 == 0 && i * 5 + j * 3 + k / 3 == 100 && i + j + k == 100) {
                    System.out.println("公鸡=" + i + " 母鸡=" + j + " 小鸡=" + k);
                }
            }
        }
        System.out.println("循环次数=" + count);
    }

    /**
     * 进一步减少枚举变量
     * x + y + z = 100 // 百鸡 ①
     * 5x + 3y + z/3 = 100 //百钱 -> 15x + 9y + z = 300 ②
     * ② - ① = 7x + 4y = 100 -> y = (100 - 7x) / 4 -> y = 25 - 7x / 4  // x为4的倍数
     */
    public static void method4() {
        int count = 0;
        for (int i = 0; i <= 20; i += 4) {
            count++;
            int j = (100 - 7 * i) / 4;
            int k = 100 - i - j;
            if ((100 - 7 * i) % 4 == 0 && j >= 0 && k % 3 == 0 &&
                    i * 5 + j * 3 + k / 3 == 100 && i + j + k == 100) {
                System.out.println("公鸡=" + i + " 母鸡=" + j + " 小鸡=" + k);
            }
        }
        System.out.println("循环次数=" + count);
    }

    public static void main(String[] args) {
        method1();
        method2();
        method3();
        method4();
    }
}
