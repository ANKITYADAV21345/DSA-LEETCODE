//memoisation
class Solution {

    int[][] memo;
    Map<Integer, Integer> map;

    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        memo = new int[n][n];
        map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.max(ans, solve(arr, i, j));
            }
        }

        return ans < 3 ? 0 : ans;
    }

    private int solve(int[] arr, int i, int j) {

        if (memo[i][j] != 0)
            return memo[i][j];

        int next = arr[i] + arr[j];

        if (!map.containsKey(next)) {
            memo[i][j] = 2;
            return 2;
        }

        int k = map.get(next);
        memo[i][j] = 1 + solve(arr, j, k);
        return memo[i][j];
    }
}
