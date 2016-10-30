/*
Challenge 5 - Longest Palindromic Substring
Write a program which takes a String as input and returns a String which is the longest palindromic substring in the input, given the following assumptions about the input string:

its maximum length is 1000
it contains one unique, longest palindromic substring
Examples:

"abdbabbdba" should return "abdba"
"abdbbbbdba" should return "abdbbbbdba"
 */

public class LongestPalindrome {
    private static  int lo, maxLen;

    public static String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        for (int i = 0; i < s.length() - 1; i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }

        return s.substring(lo, lo + maxLen);
    }

    public static void helper(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bbb"));
        // "abbbba"
    }
}