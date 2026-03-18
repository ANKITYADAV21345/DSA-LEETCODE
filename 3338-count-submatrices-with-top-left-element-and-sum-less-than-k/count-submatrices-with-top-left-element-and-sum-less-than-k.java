//18-03-2026
//AlgoDaily
class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        //do variable
        int n=grid.length;
        int m=grid[0].length;
        int []prefixSum=new int[m];
        int ans=0;

        for(int i=0;i<n;i++){
            //eek variable me row ka sum add karke store rakhege
            int rowSum=0;
            for(int j=0;j<m;j++){
                rowSum=rowSum+grid[i][j];
                prefixSum[j]=prefixSum[j]+rowSum;

                //cheak
                if(prefixSum[j]<=k){
                    ans++;
                }
            }

        }
        return ans;
    }
}