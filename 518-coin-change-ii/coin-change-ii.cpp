class Solution {
public:
    int change(int amount, vector<int>& a) {
        int n=a.size();
        vector<vector<long long>>dp (n+1,vector<long long>(amount+1,0));
        dp[0][0]=1ll;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]+=dp[i-1][j];
                if(j-a[i-1]>=0){
                    dp[i][j]+=dp[i][j-a[i-1]];
                    if(dp[i][j]>INT_MAX) dp[i][j]=0;
                }
            }
        }
        return dp[n][amount];
    }
};