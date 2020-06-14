package draft;

/**
 * Created by xwx_ on 2020/4/28
 * @author xwx_
 */
public class DfAddBinary {
    public String addBinary(String a, String b) {

        //新建StringBuilder存储相加的数据
        StringBuilder stb = new StringBuilder();

        //记录最后一位索引
        int x = a.length() - 1;
        int y = b.length() - 1;

        //用z判断是否进位
        int z = 0;

        //从尾部向第一位循环
        while (x >= 0 || y >= 0) {
            //拿到a第一个值
            if (x >= 0) z += a.charAt(x--) - '0';
            //与b第一个值相加
            if (y >= 0) z += b.charAt(y--) - '0';
            //取模，2记录0，进位1 || 1记录1，不进位 || 0为0
            stb.append(z % 2);
            //判断进位，2进位
            z >>= 1;
        }

        //反转字符串
        String res = stb.reverse().toString();
        //最后有进位，即z=1，在前面加1
        return z > 0 ? '1' + res : res;

    }


    public static void main(String[] args) {
        DfAddBinary solution = new DfAddBinary();
        String a = "10";
        String b = "10";
        String res = solution.addBinary(a, b);
        System.out.println(res);
    }
}
