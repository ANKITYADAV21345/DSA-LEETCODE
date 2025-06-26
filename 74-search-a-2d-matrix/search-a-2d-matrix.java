//apna college
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;

        int i=0,j=rows*cols-1;

        while(i<=j){
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