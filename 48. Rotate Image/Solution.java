package rotateImage;

public class Solution {
    //REFERENCE https://soulmachine.gitbooks.io/algorithm-essentials/content/java/linear-list/array/rotate-image.html
    public void rotate(int[][] matrix) {
        final int n = matrix.length;

        for (int i = 0; i < n; ++i)  // 沿着副对角线反转
            for (int j = 0; j < n - i; ++j)
                swap(matrix, i, j, n - 1 - j, n - 1 - i);

        for (int i = 0; i < n / 2; ++i) // 沿着水平中线反转
            for (int j = 0; j < n; ++j)
                swap(matrix, i, j, n - 1 - i, j);
    }
    
    private static void swap(final int[][] matrix,
            int i, int j, int p, int q) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[p][q];
        matrix[p][q] = tmp;
    }

}