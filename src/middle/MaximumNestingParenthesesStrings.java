package middle;

/**
 * Created by xwx_ on 2020/4/1
 */

import java.util.Arrays;

/**
 *
 * 有效括号字符串 定义：对于每个左括号，都能找到与之对应的右括号，反之亦然。详情参见题末「有效括号字符串」部分。
 *
 * 嵌套深度 depth 定义：即有效括号字符串嵌套的层数，depth(A) 表示有效括号字符串 A 的嵌套深度。详情参见题末「嵌套深度」部分。
 *
 * 给你一个「有效括号字符串」 seq，请你将其分成两个不相交的有效括号字符串，A 和 B，并使这两个字符串的深度最小。
 *
 * A string is a valid parentheses string (denoted VPS) if and only if it consists of "(" and ")" characters only, and:
 *
 *     It is the empty string, or
 *     It can be written as AB (A concatenated with B), where A and B are VPS's, or
 *     It can be written as (A), where A is a VPS.
 *
 * We can similarly define the nesting depth depth(S) of any VPS S as follows:
 *
 *     depth("") = 0
 *     depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's
 *     depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
 *
 * For example,  "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.
 *
 *
 *
 * Given a VPS seq, split it into two disjoint subsequences A and B, such that A and B are VPS's (and A.length + B.length = seq.length).
 *
 * Now choose any such A and B such that max(depth(A), depth(B)) is the minimum possible value.
 *
 * Return an answer array (of length seq.length) that encodes such a choice of A and B:  answer[i] = 0 if seq[i] is part of A, else answer[i] = 1.  Note that even though multiple answers may exist, you may return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: seq = "(()())"
 * Output: [0,1,1,1,1,0]
 *
 * Example 2:
 *
 * Input: seq = "()(())()"
 * Output: [0,0,0,1,1,0,1,1]
 *
 *
 *
 * Constraints:
 *
 *     1 <= seq.size <= 10000
 *
 */


public class MaximumNestingParenthesesStrings {
    public static int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int idx = 0;
        for (char c : seq.toCharArray()) {
            ans[idx++] = c == '(' ? ((idx + 1) & 1) : idx & 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        String seq = "()(())()";
        int[] res = maxDepthAfterSplit(seq);
        System.out.println(Arrays.toString(res));
    }
}
