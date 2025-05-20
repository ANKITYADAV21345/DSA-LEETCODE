class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCap = 0;
        int maxCap = 0;

        // Initialize minCap and maxCap
        for (int weight : weights) {
            minCap = Math.max(minCap, weight);
            maxCap =maxCap+weight;
        }

        // Binary search between minCap and maxCap
        while (minCap < maxCap) {
            int mid = minCap + (maxCap - minCap) / 2;

            // Calculate required days for mid capacity
            int requiredDays = 1;
            int currentLoad = 0;
            for (int weight : weights) {
                if (currentLoad + weight > mid) {
                    requiredDays++;
                    currentLoad = 0;
                }
                currentLoad += weight;
            }

            // If more days are required, increase capacity
            if (requiredDays > days) {
                minCap = mid + 1;
            } else {
                maxCap = mid;
            }
        }

        return minCap;
    }
}
