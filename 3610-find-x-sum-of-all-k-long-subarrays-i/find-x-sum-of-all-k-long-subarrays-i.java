//day 4 daily chalenge  04/nov/2025

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Frequency map for current window
        TreeMap<Integer, Integer> hm = new TreeMap<>();

        // Step 1: initialize frequency for first window
        for (int i = 0; i < k; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        // Step 2: process each window
        for (int i = 0; i <= n - k; i++) {

            // ---- Make min-heap for top x frequent elements ----
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[1] != b[1]) return a[1] - b[1]; // smaller freq = lower priority
                return a[0] - b[0];                   // for same freq, smaller value lower priority
            });

            // Add elements from map to heap
            for (int key : hm.keySet()) {
                int count = hm.get(key);
                pq.add(new int[]{key, count});
                if (pq.size() > x) pq.poll(); // keep only top x
            }

            // Collect top-x elements' values
            Set<Integer> topx = new HashSet<>();
            for (int[] pair : pq) {
                topx.add(pair[0]);
            }

            // Calculate x-sum for current window
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                if (topx.contains(nums[j])) {
                    sum += nums[j];
                }
            }
            result[i] = sum;

            // ---- Slide the window ----
            if (i + k < n) {
                // Remove leftmost element
                hm.put(nums[i], hm.get(nums[i]) - 1);
                if (hm.get(nums[i]) == 0) hm.remove(nums[i]);

                // Add new element on the right
                hm.put(nums[i + k], hm.getOrDefault(nums[i + k], 0) + 1);
            }
        }

        return result;
        
    }
}