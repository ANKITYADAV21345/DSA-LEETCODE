//apna college yt
import java.util.*;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> s = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!s.isEmpty() && nums[s.peek()] <= nums[i % n]) {
                s.pop();
            }

            if (!s.isEmpty()) {
                ans[i % n] = nums[s.peek()];
            }

            s.push(i % n);
        }

        return ans;
    }

    // For testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 1};
        int[] res = sol.nextGreaterElements(nums);
        System.out.println(Arrays.toString(res)); // Output: [2, -1, 2]
    }
}