//codetips
import java.util.*;

class Solution {
    public int minOperations(int[] nums, int[] target) {
        Set<Integer> s = new HashSet<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target[i]) {
                continue;
            }

            s.add(nums[i]);
        }

        return s.size();
    }
}