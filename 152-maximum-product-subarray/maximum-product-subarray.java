//nikhil lohia
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        long leftProduct = 1;
        long rightProduct = 1;
        long ans = nums[0];

        for (int i = 0; i < n; i++) {

            // leftProduct reset
            if (leftProduct == 0 || leftProduct < Integer.MIN_VALUE) {
                leftProduct = 1;
            } else {
                leftProduct = leftProduct;
            }

            // rightProduct reset
            if (rightProduct == 0 || rightProduct < Integer.MIN_VALUE) {
                rightProduct = 1;
            } else {
                rightProduct = rightProduct;
            }

            // prefix product
            leftProduct = leftProduct * nums[i];

            // suffix product
            rightProduct = rightProduct * nums[n - 1 - i];

            // update answer
            long maxVal = Math.max(leftProduct, rightProduct);
            ans = Math.max(ans, maxVal);
        }

        return (int) ans;
    }
}