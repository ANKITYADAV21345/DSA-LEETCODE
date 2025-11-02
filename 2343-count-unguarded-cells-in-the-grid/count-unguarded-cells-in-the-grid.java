//day 2   ->2 nov 2025  daily chalenge
class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int [][] matrix=new int [m][n];

        for(int i=0;i<guards.length;i++){
            int row=guards[i][0];
            int col=guards[i][1];
            matrix[row][col]=2;
        }

        for(int i=0;i<walls.length;i++){
            int row=walls[i][0];
            int col=walls[i][1];
            matrix[row][col]=1;
        }


        int [][] directions={{-1,0},{1,0},{0,-1},{0,1}};
                        
        for(int i=0;i<guards.length;i++){
            int row=guards[i][0];
            int col=guards[i][1];

            for(int j=0;j<directions.length;j++){
                int nextrow=row+directions[j][0];
                int nextcol=col+directions[j][1];

                while(nextrow>=0 && nextrow<m && nextcol>=0 && nextcol<n && matrix[nextrow][nextcol]!=1 && matrix[nextrow][nextcol]!=2){
                    matrix[nextrow][nextcol]=3;
                    nextrow=nextrow+directions[j][0];
                    nextcol=nextcol+directions[j][1];
                }
            }
        }

        int count =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    count++;
                }
            }
        }
        return count;

        
    }
}