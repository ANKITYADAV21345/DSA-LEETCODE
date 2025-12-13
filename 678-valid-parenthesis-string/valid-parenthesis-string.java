class Solution {

    String s;
    Boolean[][] memo;

    public boolean checkValidString(String s) {
        this.s = s;
        memo = new Boolean[s.length()][s.length() + 1];
        return dfs(0, 0);
    }

    private boolean dfs(int index, int open) {

        // invalid
        if (open < 0) return false;

        // end of string
        if (index == s.length()) {
            return open == 0;
        }

        if (memo[index][open] != null)
            return memo[index][open];

        char c = s.charAt(index);
        boolean valid;

        if (c == '(') {
            valid = dfs(index + 1, open + 1);
        } else if (c == ')') {
            valid = dfs(index + 1, open - 1);
        } else { // '*'
            valid =
                dfs(index + 1, open) ||       // empty
                dfs(index + 1, open + 1) ||   // '('
                dfs(index + 1, open - 1);     // ')'
        }

        memo[index][open] = valid;
        return valid;
    }
}
