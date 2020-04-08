/**
 * Created by xwx_ on 2020/3/16
 */
public class CompressString {
    public static String compressString(String S) {

        if (S == null || S.length() == 0) {
            return S;
        }

        StringBuilder res = new StringBuilder();
        char pre = S.charAt(0);
        int times = 1;
        for (int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);
            if (cur == pre) {
                times++;
            }else {
                res.append(pre).append(times);
                pre = cur;
                times = 1;
            }
        }
        res.append(pre).append(times);
        if (S.length()<=res.length()){
            return S;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String S = "aabbbcccdd";
        String S1 = "abbccd";
        System.out.println(compressString(S1));
    }
}
