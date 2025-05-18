import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        // Step 1: Store [digitSum, value, originalIndex]
        List<int[]> sortedList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sortedList.add(new int[]{digitSum(nums[i]), nums[i], i});
        }

        // Step 2: Sort based on digitSum, then value
        sortedList.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        // Step 3: Create index mapping from original index to new position
        int[] indexMap = new int[n];
        for (int i = 0; i < n; i++) {
            indexMap[sortedList.get(i)[2]] = i;
        }

        // Step 4: Find cycles
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || indexMap[i] == i) continue;

            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = indexMap[j];
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }

    // Helper method to calculate digit sum
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
