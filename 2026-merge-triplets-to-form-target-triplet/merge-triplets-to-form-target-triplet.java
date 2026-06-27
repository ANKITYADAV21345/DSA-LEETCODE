//web fusion with bhardwaj
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean fx=false;
        boolean fy=false;
        boolean fz=false;

        for(int i=0;i<triplets.length;i++){
            int a=triplets[i][0];
            int b=triplets[i][1];
            int c=triplets[i][2];

            if(a>target[0]|| b>target[1]||c>target[2]){
                continue;
            }


            if(a==target[0])  fx=true;
            if(b==target[1])  fy=true;
            if(c==target[2])  fz=true;


            if(fx && fy && fz) return true;
        }

        return false;



    }
}