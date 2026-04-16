//codestorywithmik
import java.util.*;

public class Solution {

    // Approach-2 (Improved Brute Force)
    // TIME COMPLEXITY < O(m * n * log(k)) - ACCEPTED

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        // Max Heap (same as C++ priority_queue default)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]   // max heap based on sum
        );

        int m = nums1.length;
        int n = nums2.length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int sum = nums1[i] + nums2[j];

                if (pq.size() < k) {
                    pq.offer(new int[]{sum, i, j});
                } 
                else if (pq.peek()[0] > sum) {
                    pq.poll();
                    pq.offer(new int[]{sum, i, j});
                } 
                else {
                    break; // 🔥 important optimization
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();

            int i = temp[1];
            int j = temp[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));
        }

        return result;
    }

    // main for testing
    public static void main(String[] args) {

        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;

        List<List<Integer>> ans = kSmallestPairs(nums1, nums2, k);

        for (List<Integer> pair : ans) {
            System.out.println(pair.get(0) + " " + pair.get(1));
        }
    }
}