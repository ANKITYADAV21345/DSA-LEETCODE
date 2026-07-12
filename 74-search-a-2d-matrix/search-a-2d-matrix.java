//apna college
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;

        int i=0,j=rows*cols-1;

        while(i<=j){
            

            //ise feel ayegi ki kyu row=mid/cols and col=mid%cols
            // Index   Row   Col    Value

            // 0       0     0       1
            // 1       0     1       3
            // 2       0     2       5
            // 3       0     3       7

            // 4       1     0      10
            // 5       1     1      11
            // 6       1     2      16
            // 7       1     3      20

            // 8       2     0      23
            // 9       2     1      30
            // 10      2     2      34
            // 11      2     3      60
            int mid=(i+j)/2;
            int row=mid/cols;
            int col=mid%cols;
            
            if(matrix[row][col]==target)
            //found the row so apply binary search in this perticular row
            return true;

            else if(matrix[row][col]<target)
            //move downward in matrix from mid
            i=mid+1;
            else
            //move upward in matrix row from mid
            j=mid-1;
        }
        return false;
    }
}