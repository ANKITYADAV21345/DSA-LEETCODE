//codebix recursion +memoisation
class Solution {
    public int numDecodings(String s) {
        int memo[]=new int[s.length()+1];
        int ans=helper(s,0,memo);
        return ans;
    }

    public int helper(String s,int index,int []memo){
        //agar epmty string hai to 1 hi ratika hai
        //"" 
        if(index==s.length()){
            return 1;
        }

        //agar "0" hai to ham kuch bhi decode nahi kar payege ise 
        if(s.charAt(index)=='0'){
            return 0;
        }

        //'1','2'
        if(index==s.length()-1){
            return 1;
        }

        if(memo[index]>0){
            return memo[index];
        }

        //single character concidered in way 1
        int way1=helper(s,index+1,memo);
        //2 character concidered in way 2
        int way2=0;
        if(Integer.parseInt(s.substring(index,index+2))<=26){  // ye condition cheak kar rahi hai ki agar ye 26 se choti hai to concider karo varna nahi
            way2=helper(s,index+2,memo);
        }

        memo[index]=way1+way2;
        return  memo[index];
    }
}