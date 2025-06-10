class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a hashmap to store the number and its index
        Map<Integer, Integer> map = new HashMap<>();
        
        // Traverse through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if complement exists in the map
            if (map.containsKey(complement)) {
                // If yes, return the indices
                return new int[] {map.get(complement), i};
            }
            
            // If not, add the current number with its index to the map
            map.put(nums[i], i);
        }
        
        // If no solution is found (although the problem guarantees a solution)
        return new int[] {-1, -1};
    }
}
// apna college vali mam ne sorted array ke liye karaya hai and isme sorted array nahi hain