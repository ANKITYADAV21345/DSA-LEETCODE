//bharat khanna

// sir ne isme array initialize karke usme s ke sare character dale hai and fir uss array me kam kiyab hai  lps vala 
class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n]; // prefix array (LPS)

        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];

            

            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }

        // The length of the longest prefix which is also suffix is lps[n-1]
        return s.substring(0, lps[n - 1]);
    }
}
