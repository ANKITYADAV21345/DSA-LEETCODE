//nikhil lohia elements ko ring ke form me swap karne vala tarika
class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        //bahar vali ring fir 1 level andar vali 
        for (int i = 0; i < (n + 1) / 2; i++) {
            //uss ring ka har element jis ring pe present pe kam chal raha hai 
            for (int j = 0; j < n / 2; j++) {
                // Start 4 way swaps
                // temp = bottom left
                int temp = matrix[n - 1 - j][i];

                // bottom left = bottom right
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];

                // bottom right = top right
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];

                // top right = top left
                matrix[j][n - 1 - i] = matrix[i][j];

                // top left = temp
                matrix[i][j] = temp;
            }
        }
    }
}