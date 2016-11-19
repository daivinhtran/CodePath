/*
 * Complete the function below.
 */
public class Problem3 {
    static int[][] dp;
    static final int MOD = 1000000007;
    static boolean[][] visited;
    static int numberOfPaths(int[][] a) {
        int rows = a.length;
        int cols = a[0].length;
        if (a[0][0] == 0 || a[rows - 1][cols -1] == 0)
            return 0;
        dp = new int[rows][cols];
        visited = new boolean[rows][cols];
        int ans = numberOfPaths(a, rows - 1, cols - 1);
        for (int[] i : dp) {
            for (int x : i)
                System.out.print(x+" ");
            System.out.println();
        }
        return ans;
    }
    static int numberOfPaths(int[][] a, int row, int col) {
        int sum = 1;
        if (row != 0 || col != 0) {
            sum--;
            if (row > 0 && a[row-1][col] == 1) 
                sum = (visited[row-1][col]) ? dp[row - 1][col] : numberOfPaths(a, row - 1, col) % MOD;
            if (col > 0 && a[row][col-1] == 1) {
                sum += (visited[row][col - 1]) ? dp[row][col - 1] : numberOfPaths(a, row, col - 1);
                sum %= MOD;
            }
        }
        visited[row][col] = true;
        dp[row][col] = sum;
        return sum;
    }
    public static void main(String[] args) {
        int[][] a = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        numberOfPaths(a);
    }
}
