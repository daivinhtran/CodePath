/*
Challenge 3 - Spiral Order
A matrix is a two-dimensional array of r rows, each with c columns, 
such that the total number of elements in the matrix is r * c.

The spiral order of such a matrix is the list of all its elements 
starting at index (0, 0) and proceeding in clockwise order from 
the outermost values to innermost values.

Write a program that takes an int[][] matrix as its input and 
returns an int[] of all the input's values in spiral order.

Example: Given the following matrix:

int[][] matrix = {
  { 1, 2, 3 },
  { 4, 5, 6 },
  { 7, 8, 9 }
};

Your program should return {1,2,3,6,9,8,7,4,5}
 */

public class SpiralOrder {
    public static int[] spiralOrder(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;

        int[] nums = new int[h * w];
        int j = 0;

        int topRow = 0;
        int bottomRow = h - 1;
        int leftCol = 0;
        int rightCol = w - 1;

        while(true) {
            // top
            if (bottomRow < topRow) break;
            for (int i = leftCol; i <= rightCol; i++) {
                nums[j++] = matrix[topRow][i];
            }
            topRow++;

            // right
            if (rightCol < leftCol) break;
            for (int i = topRow; i <= bottomRow; i++) {
                nums[j++] = matrix[i][rightCol];
            }
            rightCol--;

            // bottom
            if (bottomRow < topRow) break;
            for (int i = rightCol; i >= leftCol; i--) {
                nums[j++] = matrix[bottomRow][i];
            }
            bottomRow--;

            if (rightCol < leftCol) break;
            // left
            for (int i = bottomRow; i >= topRow; i--) {
                nums[j++] = matrix[i][leftCol];
            }
            leftCol++;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}, {2}, {3}};
        int[] nums = spiralOrder(matrix);
        for (int i : nums) {
            System.out.println(i);
        }   
    }
}