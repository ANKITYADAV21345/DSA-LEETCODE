//Learn overflow
import java.util.*;

class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(0);

        for (int i = 1; i < n; i++) {
            // nums[i] gets the max score from the last k elements
            nums[i] += nums[dq.peekFirst()];

            // Maintain deque in decreasing order of nums[]
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            // Remove elements out of the k-window
            if (i - dq.peekFirst() >= k) {
                dq.pollFirst();
            }
        }

        return nums[n - 1];
    }
}
