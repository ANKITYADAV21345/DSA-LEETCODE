//codebix + Chatgpt
class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] memo = new Integer[amount + 1][coins.length];
        return helper(amount, coins, 0, memo);
    }

    private int helper(int amount, int[] coins, int index, Integer[][] memo) {
        if (amount == 0) return 1;
        if (amount < 0 || index == coins.length) return 0;

        if (memo[amount][index] != null) return memo[amount][index];

        // Two choices: include current coin or skip it
        int include = helper(amount - coins[index], coins, index, memo);
        int exclude = helper(amount, coins, index + 1, memo);

        memo[amount][index] = include + exclude;
        return memo[amount][index];
    }
}
