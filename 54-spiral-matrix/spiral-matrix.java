//apna colege notes
import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();

        int startrow = 0;
        int startcol = 0;
        int endrow = matrix.length - 1;
        int endcol = matrix[0].length - 1;

        while (startrow <= endrow && startcol <= endcol) {

            // top
            for (int j = startcol; j <= endcol; j++) {
                result.add(matrix[startrow][j]);
            }

            // right
            for (int i = startrow + 1; i <= endrow; i++) {
                result.add(matrix[i][endcol]);
            }

            // bottom
            if (startrow < endrow) {
                for (int j = endcol - 1; j >= startcol; j--) {
                    result.add(matrix[endrow][j]);
                }
            }

            // left
            if (startcol < endcol) {
                for (int i = endrow - 1; i > startrow; i--) {
                    result.add(matrix[i][startcol]);
                }
            }

            startrow++;
            startcol++;
            endrow--;
            endcol--;
        }

        return result;
    }
}