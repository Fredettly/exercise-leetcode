/**
 * Created by xwx_ on 2020/3/19
 */

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */


public class longest_palindrome {
    public int longestPalindrome(String s) {
        int[] counter = new int[58];
        for (char c : s.toCharArray()) {
            counter[c - 'A']++;
        }
        int res = 0;
        for (int x : counter) {
            res += x - (x & 1);
        }
        return res < s.length() ? res + 1 : res;
    }
    public static void main(String[] args) {
        String s = "abccccdd";
        longest_palindrome palindrome = new longest_palindrome();
        int i = palindrome.longestPalindrome(s);
        System.out.println(i);
    }
}
