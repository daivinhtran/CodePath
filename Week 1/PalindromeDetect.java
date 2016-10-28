public class PalindromeDetect {
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        int leftPtr = 0;
        int rightPtr = str.length() - 1;

        while (leftPtr <= rightPtr) {
            char leftChar = str.charAt(leftPtr);
            char rightChar = str.charAt(rightPtr);
            if (!isValid(leftChar)) {
                leftPtr++;
                continue;
            }

            if (!isValid(rightChar)) {
                rightPtr--;
                continue;
            }

            if (leftChar != rightChar) return false;

            leftPtr++;
            rightPtr--;
        }

        return true;
    }
    
    public static boolean isValid(char a) {
        if ((a >= '0' && a <= '9') || (a >= 'a' && a <= 'z')) return true;
        return false;
    }

    public static void main(String[] args) {
        String str = "race a car";
        System.out.println(isPalindrome(str));
    }
}