
//sachin bhai se samjha tha ye ques 
class Solution {

    public void helper(List<String>ans,int openCount,int closeCount,String str,int n){

        //base case
        if(openCount==n && closeCount==n){
            ans.add(str);
        }
        else{
            //sub problem
            if(openCount>closeCount){
                helper(ans,openCount,closeCount+1,str+")",n);
            }
            if(openCount<n){
                helper(ans,openCount+1,closeCount,str+"(",n);
            }
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        int openCount=0;
        int closeCount=0;
        String str="";
        helper(ans,openCount,closeCount,str,n);
        return ans;
    }
}