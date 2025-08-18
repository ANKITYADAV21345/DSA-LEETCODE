//code harmony
class Solution {
    int[] q;

    public int minimizedMaximum(int n, int[] quantities) {
        q=quantities;
        int ans = 0;
        int left = 1, right = 100000;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (valid(mid, n)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public boolean valid(int x, int n) {
        int nn = 0;
        int m = q.length;

        for (int i = 0; i < m; i++) {
            nn = nn + (q[i] + x - 1) / x;
        }
        return nn <= n;
    }
}