/*
Challenge 1 - Deleting duplicates from a sorted array

Write a program which takes as input a sorted int[] and updates it such that:

 _ all duplicates have been removed and
 _ all remaining valid elements have been shifted left to fill the emptied indices
 _ all remaining empty indices have values set to 0

the function returns the number of remaining valid elements (the array size minus the number of removed elements)
For example, given an input array with the values {2,3,5,5,7,11,11,11,11,13}, 
after the function completes, the values in the array should be {2,3,5,7,11,13,0,0,0}, and the function should return 6.

*/
public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 5, 7, 11, 11, 11, 11, 13, 13};
        int size = removeDuplicate(arr);

        for (int i : arr) {
            System.out.println(i);
        }

        System.out.println("size: " + size);
    }

    public static int removeDuplicate(int[] nums) {
        int ptr = 1;
        int len = 0;

        while (ptr < nums.length) {
            if (nums[len] != nums[ptr]) {
                len++;
                nums[len] = nums[ptr];
            }
            ptr++;
        }

        for (int i = len + 1; i < nums.length; i++) {
            nums[i] = 0;
        }

        return len + 1;
    }
}