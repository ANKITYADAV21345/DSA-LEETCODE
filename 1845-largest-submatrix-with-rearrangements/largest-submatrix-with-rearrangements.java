//17-03-2026
//algodaily
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        
        //take row and col
        int n=matrix.length;
        int m=matrix[0].length;
        int ans=0;

        //travel matrix and find cum sum of height
        for (int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                //jab cel me 1 ho to find cum sum of height
                if(matrix[row][col]==1 && row>0){
                    matrix[row][col]=matrix[row][col]+matrix[row-1][col];
                }
            }

            //clone the curr row and sort it
            int [] currRow=matrix[row].clone();
            Arrays.sort(currRow);

            //apply the logic
            for(int i=0;i<m;i++){
                ans=Math.max(ans,currRow[i]* (m-i));
            }
        }
        return ans;
    }
}