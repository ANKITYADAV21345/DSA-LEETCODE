//codingX krishna
class Solution {
    public int[] longestCommonPrefix(String[] words) {
        int n = words.length;

        int[] leftLCP = new int[n];
        int[] rightLCP = new int[n];

        for (int i = 1; i < n; i++) {
            int currLCP = getLCP(words[i], words[i - 1]);
            leftLCP[i] = Math.max(leftLCP[i - 1], currLCP);
        }

        for (int i = n - 2; i >= 0; i--) {
            int currLCP = getLCP(words[i], words[i + 1]);
            rightLCP[i] = Math.max(rightLCP[i + 1], currLCP);
        }

        int[] ans = new int[n];

        for (int j = 0; j < n; j++) {

            int leftMax = 0;
            int rightMax = 0;

            if (j - 1 >= 0) {
                leftMax = leftLCP[j - 1];
            }

            if (j + 1 < n) {
                rightMax = rightLCP[j + 1];
            }

            int adjMax = 0;
            if (j - 1 >= 0 && j + 1 < n) {
                adjMax = getLCP(words[j - 1], words[j + 1]);
            }

            ans[j] = Math.max(leftMax, Math.max(rightMax, adjMax));
        }

        return ans;
    }

    public int getLCP(String word1, String word2) {
        int i = 0, j = 0;

        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) != word2.charAt(j)) {
                break;
            }

            i++;
            j++;
        }

        return i;
    }
}