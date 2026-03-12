class Solution {
public:
    int maxProfit(vector<int>& a) {
        int n=a.size();
        vector<vector<int>> dp(n+1,vector<int>(2,0));
        dp[0][0]=INT_MIN;
    for(int i=1;i<=n;i++){
        int p= (i-2>=0?dp[i-2][1]:0) ;
        dp[i][0]=max(dp[i-1][0],p- a[i-1]);
        dp[i][1]=max(dp[i-1][1],dp[i-1][0]+a[i-1]);
    }
    return dp[n][1];
    }
};