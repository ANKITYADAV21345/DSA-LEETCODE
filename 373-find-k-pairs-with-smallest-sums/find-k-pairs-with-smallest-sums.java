//codestorywithmik
import java.util.*;

public class Solution {

    // Approach-3 (Slight Better approach) - O(k log k)

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        int m = nums1.length;
        int n = nums2.length;

        // Min Heap (based on sum)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        // visited set to avoid duplicates
        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        int sum = nums1[0] + nums2[0];
        pq.offer(new int[]{sum, 0, 0});

        List<List<Integer>> result = new ArrayList<>();

        while (k-- > 0 && !pq.isEmpty()) {

            int[] temp = pq.poll();

            int i = temp[1];
            int j = temp[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            // Push (i, j+1)
            if (j + 1 < n) {
                String key = i + "," + (j + 1);
                if (!visited.contains(key)) {
                    pq.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                    visited.add(key);
                }
            }

            // Push (i+1, j)
            if (i + 1 < m) {
                String key = (i + 1) + "," + j;
                if (!visited.contains(key)) {
                    pq.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                    visited.add(key);
                }
            }
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