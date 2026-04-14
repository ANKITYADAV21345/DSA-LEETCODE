//codestorywithmik
//aproach 2  heap
import java.util.*;

class Solution {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        // vector<pair<int,int>> vec
        int[][] vec = new int[n][2];

        for (int i = 0; i < n; i++) {
            vec[i][0] = nums1[i];
            vec[i][1] = nums2[i];
        }

        // sort based on second (descending)
        Arrays.sort(vec, (p1, p2) -> p2[1] - p1[1]);

        // min-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long Ksum = 0;

        for (int i = 0; i <= k - 1; i++) {
            Ksum =Ksum + vec[i][0];
            pq.add(vec[i][0]);
        }

        long result = Ksum * vec[k - 1][1];

        for (int i = k; i < n; i++) {

            // taking minimum as vec[i].second
            Ksum =Ksum + vec[i][0] - pq.peek();
            pq.poll();

            pq.add(vec[i][0]);

            result = Math.max(result, Ksum * vec[i][1]);
        }

        return result;
    }
}