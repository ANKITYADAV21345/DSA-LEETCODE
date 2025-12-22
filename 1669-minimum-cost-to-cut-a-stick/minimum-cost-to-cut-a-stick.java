
//recursive+ memoisation
import java.util.Arrays;

class Solution {

    int[][] memo;
    int[] newCuts;

    public int minCost(int n, int[] cuts) {

        int c = cuts.length;

        // 0 aur n ko include karna
        newCuts = new int[c + 2];
        newCuts[0] = 0;
        newCuts[c + 1] = n;

        for (int i = 0; i < c; i++) {
            newCuts[i + 1] = cuts[i];
        }

        // cuts sort karna
        Arrays.sort(newCuts);

        // memo array
        memo = new int[c + 2][c + 2];
        for (int i = 0; i < c + 2; i++) {
            for (int j = 0; j < c + 2; j++) {
                memo[i][j] = -1;
            }
        }

        return rec(0, c + 1);
    }

    private int rec(int i, int j) {

        // base case: agar beech me koi cut nahi hai
        if (j - i <= 1)
            return 0;

        // memo check
        if (memo[i][j] != -1)
            return memo[i][j];

        int minCost = Integer.MAX_VALUE;

        // har possible cut k try karo
        for (int k = i + 1; k < j; k++) {
            int cost = rec(i, k) + rec(k, j) + (newCuts[j] - newCuts[i]);
            minCost = Math.min(minCost, cost);
        }

        memo[i][j] = minCost;
        return minCost;
    }
}
