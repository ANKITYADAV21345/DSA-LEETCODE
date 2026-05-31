//rajan keshari(iit dhanbad)
class Solution {
    public long maximumScore(int[] nums, int k) {
        int n = nums.length;

        long mxScore = 0;
        long inf = (long) Integer.MAX_VALUE * 1000L;

        int mxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[mxIdx]) {
                mxIdx = i;
            }
        }

        for (int start : new int[]{mxIdx, mxIdx + 1}) {

            long[] a = new long[k + 1];
            long[] b = new long[k + 1];
            long[] c = new long[k + 1];

            Arrays.fill(a, -inf);
            Arrays.fill(b, -inf);
            Arrays.fill(c, -inf);

            a[0] = 0;

            for (int j = start; j < start + n; ++j) {
                for (int l = k; l > 0; --l) {

                    // a[l] can come from b[l-1] or c[l-1]
                    a[l] = Math.max(a[l], b[l - 1] + nums[j % n]);
                    a[l] = Math.max(a[l], c[l - 1] - nums[j % n]);

                    // b[l-1] and c[l-1] come from a[l-1]
                    b[l - 1] = Math.max(b[l - 1], a[l - 1] - nums[j % n]);
                    c[l - 1] = Math.max(c[l - 1], a[l - 1] + nums[j % n]);
                }
            }

            for (long score : a) {
                mxScore = Math.max(mxScore, score);
            }
        }

        return mxScore;
    }
}