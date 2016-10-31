static int longestSubsequence(String x, String y) {
        char[] a = y.toCharArray();
        char[] b = x.toCharArray();
        int[][] dp = new int[a.length][b.length];
        int max = 0;
        for (int i = 0; i < a.length; i++) 
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                   dp[i][j]=(i > 0 && j > 0) ? dp[i-1][j-1]+1 : 1;
                }
                else {
                    dp[i][j] = (j > 0) ? dp[i][j-1]:0;
                }
                max = Math.max(dp[i][j], max);
            }
        return max;
    }