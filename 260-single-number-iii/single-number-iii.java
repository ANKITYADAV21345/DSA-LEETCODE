class Solution {
    public int[] singleNumber(int[] nums) {
        // XOR of all numbers; result will be XOR of the two unique numbers (a ^ b)
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        // Get the rightmost set bit in xor (a bit where a and b differ)
        int lowestBit = xor & -xor;

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & lowestBit) == 0) {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];
            }
        }

        return result;
    }
}
