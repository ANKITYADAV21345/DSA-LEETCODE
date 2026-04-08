//techdose  lower bount and upper bound ka concept bhi clear karta hai
import java.util.*;

public class Solution {

    // Helper function to calculate minimum difference
    static int solve(List<Integer> sum1, List<Integer> sum2, int tot) {
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < sum1.size(); i++) {

            // Target value we want from second array
            int target = tot / 2 - sum1.get(i);

            // Binary search (lower_bound equivalent)
            int lb = Collections.binarySearch(sum2, target);

            // If exact element not found
            if (lb < 0) {
                lb = -(lb + 1);
            }

            // Case 1: lb is at end → check previous element
            if (lb == sum2.size()) {
                int val = sum1.get(i) + sum2.get(lb - 1);
                minDiff = Math.min(minDiff, Math.abs(tot - 2 * val));
            }
            // Case 2: lb is at beginning
            else if (lb == 0) {
                int val = sum1.get(i) + sum2.get(lb);
                minDiff = Math.min(minDiff, Math.abs(tot - 2 * val));
            }
            // Case 3: check both lb and lb-1
            else {
                int val1 = sum1.get(i) + sum2.get(lb - 1);
                int val2 = sum1.get(i) + sum2.get(lb);

                minDiff = Math.min(minDiff,
                        Math.min(Math.abs(tot - 2 * val1),
                                 Math.abs(tot - 2 * val2)));
            }
        }
        return minDiff;
    }

    public static int minimumDifference(int[] nums) {

        int n = nums.length / 2;
        int tot = 0; // total sum of array

        // Split array into two halves
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];

        for (int i = 0; i < n; i++) {
            nums1[i] = nums[i];
            nums2[i] = nums[i + n];
            tot += nums[i] + nums[i + n];
        }

        // Array of lists → sum1[k] stores all subset sums of size k
        List<Integer>[] sum1 = new ArrayList[n + 1];
        List<Integer>[] sum2 = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            sum1[i] = new ArrayList<>();
            sum2[i] = new ArrayList<>();
        }

        // Generate all subset sums using bitmask
        for (int mask = 0; mask < (1 << n); mask++) {

            int tot1 = 0, tot2 = 0, count = 0;

            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    tot1 += nums1[j];
                    tot2 += nums2[j];
                    count++;
                }
            }

            // Store sums based on number of elements chosen
            sum1[count].add(tot1);
            sum2[count].add(tot2);
        }

        // Sort second half for binary search
        for (int i = 0; i <= n; i++) {
            Collections.sort(sum2[i]);
        }

        int minDiff = Integer.MAX_VALUE;

        // Try all combinations where total elements = n
        for (int i = 0; i <= n; i++) {
            minDiff = Math.min(minDiff,
                    solve(sum1[i], sum2[n - i], tot));
        }

        return minDiff;
    }

    // Main function (for testing)
    public static void main(String[] args) {
        int[] nums = {3, 9, 7, 3};

        System.out.println(minimumDifference(nums));
    }
}