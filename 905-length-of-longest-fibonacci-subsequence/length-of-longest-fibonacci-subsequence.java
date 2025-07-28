class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        if(arr==null || arr.length==0){
            return 0;
        }
        int len=arr.length;
        int [][] dp=new int [len][len];
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<len;i++){
            m.put(arr[i],i);
            for(int j=i+1;j<len;j++){
                dp[i][j]=2;
            }
        }
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int k=arr[j]+arr[i];
                if(m.containsKey(k)){
                    int index=m.get(k);
                    dp[j][index]=dp[i][j]+1;
                }
            }
        }
        int res=0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                res=Math.max(res,dp[i][j]);
            }
        }
        return res==2?0: res;
    }
}