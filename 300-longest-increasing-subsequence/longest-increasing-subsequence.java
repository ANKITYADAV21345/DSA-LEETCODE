//apna college notes
import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums1) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        int[] nums2 = new int[set.size()];
        int i = 0;
        for (int val : set) {
            nums2[i++] = val;
        }
        Arrays.sort(nums2);

        return lcs(nums1, nums2);
    }

    public static int lcs(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
