class Solution {
    // Function to rearrange the array
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length; // Get the length of the input array
        int[] result = new int[n]; // Initialize a new array to hold the rearranged result
        int posIndex = 0; // Index for placing positive numbers (starting at index 0)
        int negIndex = 1; // Index for placing negative numbers (starting at index 1)

        // Iterate through each number in the input array
        for (int num : nums) {
            // Check if the number is positive
            if (num > 0) {
                result[posIndex] = num; // Place the positive number at the current positive index
                posIndex += 2; // Move to the next even index for the next positive number
            } else {
                result[negIndex] = num; // Place the negative number at the current negative index
                negIndex += 2; // Move to the next odd index for the next negative number
            }
        }

        // Return the rearranged result array
        return result;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        Solution sol = new Solution(); // Create an instance of the Solution class
        int[] nums = {3, 1, -2, -5, 2, -4}; // Input array to be rearranged
        int[] result = sol.rearrangeArray(nums); // Call the rearrangeArray method

        // Print the result array to see the output
        for (int num : result) {
            System.out.print(num + " "); // Print each element followed by a space
        }
        // The output should be an array where positive and negative numbers alternate
        // Example output could be: 3 -2 1 -5 2 -4
    }
}
