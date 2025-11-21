//done by own 
class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;

        int ans = 0;

        for (int i = 1; i < n - 1; i++) {

            // peak condition
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;
                int count = 1;

                // count left increasing
                while (left >= 0 && arr[left] < arr[left + 1]) {
                    count++;
                    left--;
                }

                // count right decreasing
                while (right < n && arr[right] < arr[right - 1]) {
                    count++;
                    right++;
                }

                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}

