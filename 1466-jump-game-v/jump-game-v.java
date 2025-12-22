import java.util.*;

class Solution {

    public int maxJumps(int[] arr, int d) {

        int n = arr.length;
        int[] dp = new int[n];

        // har index se minimum 1 jump
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // index array
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        // 🔁 simple sorting (bubble sort) based on height
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[idx[j]] > arr[idx[j + 1]]) {
                    int temp = idx[j];
                    idx[j] = idx[j + 1];
                    idx[j + 1] = temp;
                }
            }
        }

        // bottom-up DP
        for (int x = 0; x < n; x++) {

            int id = idx[x];

            // left side
            for (int j = id - 1; j >= 0 && j >= id - d; j--) {
                if (arr[j] >= arr[id])
                    break;
                dp[id] = Math.max(dp[id], 1 + dp[j]);
            }

            // right side
            for (int j = id + 1; j < n && j <= id + d; j++) {
                if (arr[j] >= arr[id])
                    break;
                dp[id] = Math.max(dp[id], 1 + dp[j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
