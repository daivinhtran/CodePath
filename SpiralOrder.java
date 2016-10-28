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
            for (int i = leftCol; i <= rightCol; i++) {
                nums[j++] = matrix[topRow][i];
            }
            topRow++;

            // right
            for (int i = topRow; i <= bottomRow; i++) {
                nums[j++] = matrix[i][rightCol];
            }
            rightCol--;

            if (bottomRow >= topRow) {
                // bottom
                for (int i = rightCol; i >= leftCol; i--) {
                    nums[j++] = matrix[bottomRow][i];
                }
                bottomRow--;
            }

            if (rightCol < leftCol) break;
            // left
            for (int i = bottomRow; i >= topRow; i--) {
                nums[j++] = matrix[i][leftCol];
            }
            leftCol++;

            if (rightCol < leftCol) break;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[][] matrix = {
          { 1, 2, 3 },
          { 4, 5, 6 }
        };
        int[] nums = spiralOrder(matrix);
        for (int i : nums) {
            System.out.println(i);
        }   
    }
}