//codestorywithmik 
//recursion with backtracking
class Solution {
    int n;
    public List<List<String>> partition(String s) {
        n=s.length();
        List<List<String>> result=new ArrayList<>();
        List<String> curr=new ArrayList<>();
        backtrack(s,0,curr,result);
        return result;
    }

    public void backtrack(String s,int idx,List<String> curr,List<List<String>> result){
        
        //base case
        if(idx==n){
            result.add(new ArrayList<>(curr));
        }

        for(int i=idx;i<n;i++){
            if(isPalindrome(s,idx,i)){
                curr.add(s.substring(idx,i+1));
                backtrack(s,i+1,curr,result);
                curr.remove(curr.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s,int left,int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}