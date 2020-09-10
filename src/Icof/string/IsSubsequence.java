package Icof.string;

/**
 * 392. 判断子序列
 */

public class IsSubsequence {

	public boolean isSubsequence(String s, String t) {
		int i = 0, j = 0;
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
			}
			j++;
		}
		return i == s.length();
	}

	public static void main(String[] agrs) {
		IsSubsequence solution = new IsSubsequence();
		System.out.println(solution.isSubsequence("abc", "haaisbljc"));
	}
}