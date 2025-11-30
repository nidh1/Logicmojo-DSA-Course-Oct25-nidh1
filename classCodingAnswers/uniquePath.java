class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(m, n, dp, 0, 0);
    }

    public int helper(int m, int n, int[][] dp, int i, int j){
        if(i==m-1 && j==n-1){
            return 1;
        }

        if(i==m || j==n){
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int down = helper(m, n, dp, i+1, j);
        int right = helper(m, n, dp, i, j+1);

        dp[i][j] = down+right;
        return dp[i][j];
    }
}
