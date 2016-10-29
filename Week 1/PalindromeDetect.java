vi/*
Challenge 4 - Palindrome detection

A palindrome is a word, phrase, or sequence of characters that reads 
the same backward as forward, e.g., madam or nurses run.

Write a program which takes a String as input and returns a boolean 
value which is true if the input is a palindrome and false if it is 
not, considering only alphanumeric characters and ignoring case.

Example:

_ "A man, a plan, a canal: Panama" is a palindrome and should return true
_ "race a car" is not a palindrome and should return false
 */
public class PalindromeDetect {
    public static boolean isPalindrome(String str) {

        int leftPtr = 0;
        int rightPtr = str.length() - 1;
        char[] arr = str.toLowerCase().toCharArray();

        while (leftPtr < rightPtr) {
            
            while (!isValid(arr[leftPtr])) {
                leftPtr++;
            }

            while (!isValid(arr[rightPtr])) {
                rightPtr--;
            }

            if (arr[leftPtr++] != arr[rightPtr--]) return false;
        }

        return true;
    }
    
    public static boolean isValid(char a) {
        return ((a >= '0' && a <= '9') || (a >= 'a' && a <= 'z'));
    }

    public static void main(String[] args) {
        String str = "a         a";
        System.out.println(isPalindrome(str));
    }
}