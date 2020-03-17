/**
 * Created by xwx_ on 2020/3/17
 */

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *     1.Open brackets must be closed by the same type of brackets.
 *     2.Open brackets must be closed in the correct order.
 *
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 *
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 *
 */
public class valid_parentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                deque.push(c);
            } else {
                if (deque.size() == 0 || map.get(c) != deque.pop()) return false;
            }
        }
        return deque.size() == 0;
    }

    public static void main(String[] args) {
        valid_parentheses validParentheses = new valid_parentheses();
        System.out.println(validParentheses.isValid("{[()]}{()}"));
//        System.out.println(validParentheses.isValid("([)]"));
    }
}
