package setMatrixZeroes;

/* 时间复杂度O(mn)，空间复杂度O(1)。因为复用了第一行第一列，所以节省了空间开销。
首先用两个boolean记录第一行第一列是否含有0.然后再去一行一行、一列一列检查是否含有0，
如果含有则将对应的行/列的第一个置为0.最后再去处理第一行第一列。*/
public class Solution {
 public void setZeroes(int[][] matrix) {
     final int m = matrix.length;
     final int n = matrix[0].length;
     boolean row_has_zero = false; // 第一行是否存在 0
     boolean col_has_zero = false; // 第一列是否存在 0

     for (int i = 0; i < n; i++)
         if (matrix[0][i] == 0) {
             row_has_zero = true;
             break;
         }

     for (int i = 0; i < m; i++)
         if (matrix[i][0] == 0) {
             col_has_zero = true;
             break;
         }

     for (int i = 1; i < m; i++)
         for (int j = 1; j < n; j++)
             if (matrix[i][j] == 0) {
                 matrix[0][j] = 0;
                 matrix[i][0] = 0;
             }
     for (int i = 1; i < m; i++)
         for (int j = 1; j < n; j++)
             if (matrix[i][0] == 0 || matrix[0][j] == 0)
                 matrix[i][j] = 0;
     if (row_has_zero)
         for (int i = 0; i < n; i++)
             matrix[0][i] = 0;
     if (col_has_zero)
         for (int i = 0; i < m; i++)
             matrix[i][0] = 0;
 }
}