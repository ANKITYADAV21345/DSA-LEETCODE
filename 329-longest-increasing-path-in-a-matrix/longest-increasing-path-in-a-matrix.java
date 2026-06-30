//ayushi sharma
class Solution {
    int helper[][] = new int[200][200];
    int maxPath, n, m;

    public int longestIncreasingPath(int[][] matrix) {
        maxPath = 0;
        n = matrix.length;
        m = matrix[0].length;

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                maxPath = Math.max(maxPath, solve(matrix, i, j, -1));

        return maxPath;
    }

    public int solve(int[][] mat, int i, int j, int prev){
        if(i < 0 || j < 0 || i >= n || j >= m || mat[i][j] <= prev)
            return 0;

        if(helper[i][j] != 0)
            return helper[i][j];

        return helper[i][j] = 1 + Math.max(
                                    Math.max(solve(mat, i + 1, j, mat[i][j]),
                                             solve(mat, i - 1, j, mat[i][j])),
                                    Math.max(solve(mat, i, j + 1, mat[i][j]),
                                             solve(mat, i, j - 1, mat[i][j]))
                                );
    }
}