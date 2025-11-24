//done by own(tabular)

//table
//   0 1 2 3 4      
// 0 T F T F F
// 1   T F T F
// 2     T F F
// 3       T F
// 4         T



class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        String ans="";
        int maxLen=0;

        //fill table from botom to top
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){

                //case 1 single char
                if(i==j){
                    dp[i][j]=true;
                }

                //two characters  (ADJACENT CHARACTER CHEAK WEATHER SAME OR NOT)
                else if(j-i==1 && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
                }

                //case 3 length3 or more 
                else if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j]=true;
                }

                //TRACK longest
                if(dp[i][j]&& (j-i+1>maxLen)){
                    maxLen=j-i+1;
                    ans=s.substring(i,j+1);  // j+1 iss liye kyoki substring me last index include nahi hota
                }
            }
        }
        return ans;
    }
}