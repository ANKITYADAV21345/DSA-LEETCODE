//codebix tabulation
class Solution {
    public int numDecodings(String s) {
        int ans=tabulation(s);
        return ans;
    }
    public int tabulation(String s){
        //handle cases like"023" jaha pehla hi leter 0 ho to 0 return  (not posible) 
        if(s==null||s.length()==0){
            return 0;
        }
        int n=s.length();
        int[] dp=new int[n+1];
        
        dp[0]=1;

        if(s.charAt(0)!='0'){
            //empty string ko decode karne ka eek tarika 
            dp[1]=1;
        }
        else{
            //agar starting me hi 0 aa gaya to 0 dal dehe 
            dp[1]=0;
        }

        for(int i=2;i<=n;i++){
            //index concidered in first=[12)
            //number 1123  value 1 is concidered at index 1 only
            int first=Integer.valueOf(s.substring(i-1,i));
            //index concidered in first=[02)
            //number 1123  value 11 is concidered at index 0,1
            int second=Integer.valueOf(s.substring(i-2,i));
            if(first>=1 && first<=9){
                dp[i]=dp[i]+dp[i-1];
            }
            if(second>=10 && second<=26){
                dp[i]=dp[i]+dp[i-2];
            }
        }
        return dp[n];
    }
}