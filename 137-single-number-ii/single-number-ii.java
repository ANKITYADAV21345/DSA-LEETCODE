//nikhil lohia thoda tha tweek kiya hai nikhil lohiya ka single no 1 ka code though chatgpt
class Solution {
    public int singleNumber(int[] nums) {

        // variables to hold bits that appeared once and twice
        int ones = 0, twos = 0;

        // start the loop for all elements
        for (int i = 0; i < nums.length; i++) {
            // update ones and twos using bitwise operations
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }

        // return the single number that appears only once
        return ones;
    }
}
