class Solution {

    int n;
    String s;
    int[][] memo;

    public int countSubstrings(String s) {

        this.s = s;
        n = s.length();
        memo = new int[n][n];

        // initialize memo with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        int count = 0;

        // try all substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isPalindrome(int i, int j) {

        // base case
        if (i >= j) return true;

        // if already computed
        if (memo[i][j] != -1)
            return memo[i][j] == 1;

        boolean result = false;

        if (s.charAt(i) == s.charAt(j)) {
            result = isPalindrome(i + 1, j - 1);
        }

        memo[i][j] = result ? 1 : 0;

        return result;
    }
}