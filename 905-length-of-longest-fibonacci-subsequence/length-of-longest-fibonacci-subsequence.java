class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length;
        int [][] dp=new int [n][n];

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }

        int ans=0;
        for(int j=n-1;j>=0;j--){
            for(int i=j-1;i>=0;i--){
                int next=arr[i]+arr[j];

                if(map.containsKey(next)){
                    int k=map.get(next);
                    dp[i][j]=1+dp[j][k];
                }else{
                    dp[i][j]=2;
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }
        if(ans>=3){
            return ans;
        }else{
            return 0;
        }
    }
}