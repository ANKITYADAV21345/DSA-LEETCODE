//algo daily
//22-03-2026
class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int row=mat.length;
        int col=mat[0].length;

        for(int i=0;i<4;i++){
            //compare same then return true
            if(compare(mat,target)){
                return true;
            }
            rotate(mat);//then rotate
        }

        //no match 
        return false;
    }

    public boolean compare(int [][] mat,int [][] target){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]!=target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }


    //methord for rotate
    public void rotate(int [][] mat){
        int row=mat.length;
        int col=mat[0].length;

        //transpose
        for(int i=0;i<row;i++){
            for(int j=i;j<col;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }

        //reverse
        for(int i=0;i<col;i++){
            int left=0;
            int right=col-1;

            while(left<right){
                int temp=mat[i][left];
                mat[i][left]=mat[i][right];
                mat[i][right]=temp;
                left++;
                right--;
            }
        }
    }
}