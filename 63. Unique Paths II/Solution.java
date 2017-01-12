package uniquePathsII;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) return 0;
        
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(m==0||n==0) return 0;
        
        int[][] dp=new int[m][n];
        dp[0][0]=1;
        for(int i=1;i<m;i++){
            dp[i][0]=(obstacleGrid[i][0]==1?0:dp[i-1][0]);
        }
        for(int j=1;j<n;j++){
            dp[0][j]=(obstacleGrid[0][j]==1?0:dp[0][j-1]);
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=(obstacleGrid[i][j]==1?0:dp[i-1][j]+dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}