//done by mu own (recursion+memoisation)
class Solution {

    //memo table
    String[][] memo;

    public String expand(String s,int left,int right){

        //if already computed
        if(left>=0 && right<s.length() && memo[left][right]!=null){
            return memo[left][right];
        }

        //base case boundry cross or mismatch
        if(left<0 ||right>=s.length() ||s.charAt(left)!=s.charAt(right)){
            return s.substring(left+1,right);
        }

        //recursively expand bothdirections
        String ans=expand(s,left-1,right+1);

        //store in memo(only if valid index)
        if(left>=0 && right<s.length()){
            memo[left][right]=ans;
        }
        return ans;
    }
    public String longestPalindrome(String s) {
        memo=new String[s.length()][s.length()];
        String longest="";

        for(int i=0;i<s.length();i++){

            //odd length centre
            String odd=expand(s,i,i);

            //even length centre
            String even=expand(s,i,i+1);

            //cheak max
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