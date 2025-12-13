//RECURSION + MEMOISATION
class Solution {

    int[] memo;

    public int minSteps(int n) {
        memo = new int[n + 1];
        return solve(n);
    }

    private int solve(int n) {

        if (n == 1) return 0;

        if (memo[n] != 0)
            return memo[n];

        int ans = n; // worst case: copy 1, paste (n-1) times

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                ans = Math.min(ans, solve(n / i) + i);
            }
        }

        memo[n] = ans;
        return ans;
    }
}




