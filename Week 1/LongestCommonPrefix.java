/*
Challenge 6 - Longest Common Prefix
Write a program which takes a String[] as input and returns a String which is the longest common prefix, or an empty string if there is none.

Examples:

_ {"bceefgh", "bcfghijk", "bcefgh"} should return "bc"
_ {"abcdefgh", "aefghijk", "abcefgh"} should return "a"
_ {"", "aefghijk", "abcefgh"} should return ""
*/
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return new String();

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int ptr = 0;
            while (ptr < prefix.length()
                    && ptr < strs[i].length()
                    && prefix.charAt(ptr) == strs[i].charAt(ptr)) {
                ptr++;
            }

            prefix = prefix.substring(0, ptr);
        }

        return prefix;
    }
    public static void main(String[] args) {
        String[] strs = {"abcdefgh", "aefghijk", "abcefgh"};
        System.out.println(longestCommonPrefix(strs));
    }
}