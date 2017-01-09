package uniquePaths;

public class Solution {
    //设状态为f[i][j]，表示从起点(1,1)到达(i,j)的路线条数，则状态转移方程为：f[i][j]=f[i-1][j]+f[i][j-1]
    //滚动数组实际是一种节省空间的办法，时间上没太大优势，多用于DP中。如下：
    public int uniquePaths(int m, int n) {
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                /* 左边的f[j]，表示更新后的f[j]，与公式中的f[i][j]对应
                   右边的f[j]，表示老的f[j]，与公式中的f[i-1][j]对应
                   f[i][j]=f[i-1][j]+f[i][j-1]是从左和上得到右下。
                   f[j] = f[j] + f[j - 1]可以看做是先把第一排从左至右算完，再算第二排……直到最后一排。
                */
                f[j] = f[j] + f[j - 1];
            }
        }
        return f[n - 1];
    }
}