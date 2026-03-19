//code story with mik
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int [][] cumSumX=new int[n][m];
        int [][] cumSumY=new int[n][m];

        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(grid[i][j]=='X'){
                    cumSumX[i][j]=1;
                }else{
                    cumSumX[i][j]=0;
                }


                if(grid[i][j]=='Y'){
                    cumSumY[i][j]=1;
                }else{
                    cumSumY[i][j]=0;
                }



                if(i-1>=0){
                    cumSumX[i][j]=cumSumX[i][j]+cumSumX[i-1][j];
                    cumSumY[i][j]=cumSumY[i][j]+cumSumY[i-1][j];
                }

                if(j-1>=0){
                    cumSumX[i][j]=cumSumX[i][j]+cumSumX[i][j-1];
                    cumSumY[i][j]=cumSumY[i][j]+cumSumY[i][j-1];
                }

                if(i-1>=0 && j-1>=0){
                    cumSumX[i][j]=cumSumX[i][j]-cumSumX[i-1][j-1];
                    cumSumY[i][j]=cumSumY[i][j]-cumSumY[i-1][j-1];
                }

                if(cumSumX[i][j]==cumSumY[i][j] && cumSumX[i][j]>0){
                    count++;
                }
            }
        }
        return count;
    }
}