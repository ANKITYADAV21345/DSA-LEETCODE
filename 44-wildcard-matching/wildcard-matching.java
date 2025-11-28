//recursion +tabular
class Solution {

    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()+1][p.length()+1];
        return solve(s, p, s.length()-1, p.length()-1);
    }

    private boolean solve(String s, String p, int i, int j) {

        if (i < 0 && j < 0) return true;
        if (j < 0 && i >= 0) return false;

        if (i < 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        if (memo[i][j] != null) return memo[i][j];

        boolean ans;
        char cs = s.charAt(i);
        char cp = p.charAt(j);

        if (cs == cp || cp == '?') {
            ans = solve(s, p, i-1, j-1);
        }
        else if (cp == '*') {
            ans = solve(s, p, i-1, j)  // * consumes char
               || solve(s, p, i, j-1); // * matches empty
        }
        else {
            ans = false;
        }

        return memo[i][j] = ans;
    }
}
