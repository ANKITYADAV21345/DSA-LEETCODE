// inc[i] = length of increasing sequence ending at i

// dec[i] = length of decreasing sequence starting at i

// Mountain tab banegi jab:

// inc[i] > 1 && dec[i] > 1
// length = inc[i] + dec[i] - 1



class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;

        int[] inc = new int[n];
        int[] dec = new int[n];

        // increasing sequence
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                inc[i] = inc[i - 1] + 1;
            }
        }

        // decreasing sequence
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                dec[i] = dec[i + 1] + 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (inc[i] > 0 && dec[i] > 0) {
                ans = Math.max(ans, inc[i] + dec[i] + 1);
            }
        }

        return ans;
    }
}


