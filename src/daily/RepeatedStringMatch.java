package daily;

/**
 * 686. 重复叠加字符串匹配
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 * <p>
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 * 示例 2：
 * <p>
 * 输入：a = "a", b = "aa"
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：a = "a", b = "a"
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：a = "abc", b = "wxyz"
 * 输出：-1
 *
 * @author xwx
 * @since 2021/12/22
 */
public class RepeatedStringMatch {

    public static int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length() && ++ans > 0) {
            sb.append(a);
        }
        sb.append(a);
        int idx = sb.indexOf(b);
        if (idx == -1) {
            return -1;
        }
        return idx + b.length() > a.length() * ans ? ans + 1 : ans;
    }

    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdabcdab";
        System.out.println(repeatedStringMatch(a, b));
    }
}
