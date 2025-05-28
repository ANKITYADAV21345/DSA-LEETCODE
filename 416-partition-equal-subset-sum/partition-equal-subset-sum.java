import java.util.*;

public class Solution {
    public boolean recursion(List<Integer> nums, int i, int sum, Map<String, Boolean> map) {
        String key = i + "," + sum;

        if (map.containsKey(key)) return map.get(key);
        if (sum < 0) return false;
        if (sum == 0) return true;
        if (i == nums.size()) return false;

        boolean result = recursion(nums, i + 1, sum - nums.get(i), map) || recursion(nums, i + 1, sum, map);
        map.put(key, result);

        return result;
    }

    public boolean canPartition(int[] numsArray) {
        int sum = 0;
        for (int num : numsArray) {
            sum += num;
        }

        if (sum % 2 != 0) return false;

        List<Integer> nums = new ArrayList<>();
        for (int num : numsArray) {
            nums.add(num);
        }

        Map<String, Boolean> map = new HashMap<>();
        return recursion(nums, 0, sum / 2, map);
    }
}
