//rajan keshari(iit  dhanbad)
import java.util.*;

class Solution {

    int[] BIT = new int[100001];
    int n;

    void update(int x, int delta) {
        for (; x <= n; x += (x & -x)) {
            BIT[x] += delta;
        }
    }

    int query(int x) { // elements < x in window
        int sum = 0;
        for (; x > 0; x -= (x & -x)) {
            sum += BIT[x];
        }
        return sum;
    }

    public long minInversionCount(int[] nums, int k) {
        n = nums.length;

        int[] comp = nums.clone();
        Arrays.sort(comp);

        int m = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || comp[i] != comp[i - 1]) {
                comp[m++] = comp[i];
            }
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = lowerBound(comp, m, nums[i]) + 1;
        }

        long current = 0;

        for (int i = 0; i < k; i++) {
            current += i - query(arr[i]);
            update(arr[i], 1);
        }

        long ans = current;

        for (int i = k; i < n; i++) {
            update(arr[i - k], -1);

            current -= query(arr[i - k] - 1);
            current += (k - 1) - query(arr[i]);

            update(arr[i], 1);

            ans = Math.min(ans, current);
        }

        return ans;
    }

    private int lowerBound(int[] arr, int len, int target) {
        int l = 0, r = len;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}