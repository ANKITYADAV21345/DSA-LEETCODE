class Solution {
    public int maxDepth(String s) {
        int max=0;
        int curr=0;

        for(char ch:s.toCharArray()){
            if(ch=='('){
                curr++;
                if(curr>max)
                    max=curr;
            }
            else if(ch==')')
                curr--;
        }
        return max;
    }
}