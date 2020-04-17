/**
 * Created by xwx_ on 2020/3/7
 */

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 */



public class AddBinary {
    public String addBinary(String a, String b) {
 /*
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0)

        {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
        */



        StringBuilder stb = new StringBuilder();
        int x = a.length() - 1;
        int y = b.length() - 1;
        int c = 0;

        while (x >= 0 || y >= 0){
            if (x >= 0) c += a.charAt(x--) -'0';
            if (y >= 0) c += b.charAt(y--) -'0';
            stb.append(c % 2);
            c >>= 1;
        }

        String res = stb.reverse().toString();
        return c > 0 ? '1' + res : res;

    }



    public static void main(String[] args) {
        String a = "10";
        String b = "1";
        System.out.println(new AddBinary().addBinary(a, b));
    }
}

