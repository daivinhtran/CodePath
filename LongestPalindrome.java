public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int maxLen = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            left = i;
            right = i;


            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                } else {
                    break;
                }
            }

            left++;
            right--;
            if (maxLen < (right - left + 1)) {
                maxLeft = left;
                maxRight = right;
                maxLen = maxRight - maxLeft + 1;
            }


            left = i;
            right = i;

            if (s.charAt(right + 1) == s.charAt(left)) {
                right++;
                while (left >= 0 && right < s.length()) {
                    if (s.charAt(left) == s.charAt(right)) {
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }

                left++;
                right--;
                if (maxLen < (right - left + 1)) {
                    maxLeft = left;
                    maxRight = right;
                    maxLen = maxRight - maxLeft + 1;
                }
            }
        }

        return s.substring(maxLeft, maxRight + 1);
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bbb"));
        // "abbbba"
    }
}