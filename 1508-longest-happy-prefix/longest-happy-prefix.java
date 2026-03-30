//bharat khanna
// sir ke code me agar string di hoti hai c++ me to uske elements ko array ke element ki tarah bhi kam kar sake hai hamare me java me aisa nahi hai
 
class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n]; // prefix array (LPS)

        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];

            if (s.charAt(j) == s.charAt(i)) {
                lps[i] = j + 1;
                continue;
            }else{ 
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j--;
                    j = lps[j];
                }
                if (s.charAt(i) == s.charAt(j)) {
                lps[i]=j+1;
                }
            }
        }

        // The length of the longest prefix which is also suffix is lps[n-1]
        return s.substring(0, lps[n - 1]);
    }
}
