//study placement
class Solution {
    int dp[];
    int arr[];
    public int climbStairs(int n, int[] costs) {
        arr=new int [n+1];
        dp=new int [n+1];
        Arrays.fill(dp,-1);
        for(int i=0;i<costs.length;i++){
            arr[i+1]=costs[i];
        }
        return solve(n);
    }

    public int solve(int n){
        if(n==0) return 0;
        if(n==1) return cost(0,1);
        if(n==2) return Math.min(solve(1)+cost(1,2),cost(0,2));
        if(dp[n]!=-1) return dp[n];

        int x=solve(n-1)+cost(n-1,n);
        int y=solve(n-2)+cost(n-2,n);
        int z=solve(n-3)+cost(n-3,n);
        return dp[n]=Math.min(x,Math.min(y,z));
    }

    public int cost(int i,int j){
        return arr[j]+(j-i)*(j-i);
    }
}