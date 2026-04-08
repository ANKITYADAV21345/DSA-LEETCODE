//codestorrywithmik
//feel dila di sir ne issi se samajna 
import java.util.*;

class Solution {

    static int[][] t = new int[103][103];

    public static int solve(int[] cuts, int left, int right) {

        if (right - left == 1)
            return 0;

        if (t[left][right] != -1)
            return t[left][right];

        int result = Integer.MAX_VALUE;

        for (int index = left + 1; index <= right - 1; index++) {

            int cost = solve(cuts, left, index)
                    + solve(cuts, index, right)
                    + (cuts[right] - cuts[left]);

            result = Math.min(result, cost);
        }

        return t[left][right] = result;
    }

    public int minCost(int n, int[] cuts) {

        int m = cuts.length;
        int[] newCuts = new int[m + 2];

        // add 0 and n
        newCuts[0] = 0;
        newCuts[m + 1] = n;

        for (int i = 0; i < m; i++) {
            newCuts[i + 1] = cuts[i];
        }

        Arrays.sort(newCuts);

        // initialize dp with -1
        for (int i = 0; i < 103; i++) {
            Arrays.fill(t[i], -1);
        }

        return solve(newCuts, 0, m + 1);
    }

    // optional main for testing
    public static void main(String[] args) {
        Solution obj = new Solution();
        int n = 7;
        int[] cuts = {1, 3, 4, 5};

        System.out.println(obj.minCost(n, cuts));
    }
}