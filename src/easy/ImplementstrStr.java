/**
 * Created by xwx_ on 2020/4/5
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        char[] array = haystack.toCharArray();
        char[] index = needle.toCharArray();
        char first = index[0];
        for (int j = 0; j < array.length; j++) {
            if (array[j] == first) {
                if (isMach(array, index, j)) {
                    return j;
                }else {
                    continue;
                }
            }
        }
        return -1;
    }

    private boolean isMach(char[] array, char[] index, int j) {
        boolean isMach = true;
        int i = j + 1, k = 1;
/*        for (int k = 0; k < index.length - 1; k++) {
            if (index[k] == array[i]) {
                i++;
                isMach = true;
            } else {
                return false;
            }
        }*/
        while (i < array.length && k < index.length) {
            if (index[k] == array[i]) {
                i++;
                k++;
                isMach = true;
            } else {
                return false;
            }
        }
        if (i == array.length && k < index.length) {
            return false;
        } else {
            return isMach;
        }
    }

    public static void main(String[] args) {
//        String a = "hello";
        String a = "babba";
        String b = "bbb";
        ImplementstrStr solution = new ImplementstrStr();
        int res = solution.strStr(a, b);
        System.out.println(res);
    }
}
