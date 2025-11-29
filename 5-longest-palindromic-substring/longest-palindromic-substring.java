class Solution {

    String [][] memo;
    public String expand(String s,int left ,int right){
        if(left>=0 && right<s.length() && memo[left][right]!=null){
            return memo[left][right];
        }

        //base case 
        if(left<0 || right>=s.length()|| s.charAt(left)!=s.charAt(right)){
            return s.substring(left+1,right);
        }

        String ans=expand(s,left-1,right+1);

        if(left>=0 && right<s.length()){
            memo[left][right]=ans;
        }
        return ans;
    }

    public String longestPalindrome(String s) {
        memo=new String[s.length()][s.length()];
        String longest="";

        for(int i=0;i<s.length();i++){
            String odd=expand(s,i,i);
            String even=expand(s,i,i+1);
            if(odd.length()>longest.length()){
                longest=odd;
            }
            if(even.length()>longest.length()){
                longest=even;
            }
        }
        return longest;
    }
}