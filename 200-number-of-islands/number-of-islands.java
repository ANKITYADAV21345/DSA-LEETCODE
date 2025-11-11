//solved by own
class Solution {
    public int numIslands(char[][] grid) {
        int count =0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    solve(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void solve(char [][] grid,int i,int j){
        //dead ends
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]=='0' || grid[i][j]=='3'){
            return;
        }

        grid[i][j] = '3';

        solve(grid,i+1,j);
        solve(grid,i,j+1);
        solve(grid,i-1,j);
        solve(grid,i,j-1);
    }
}