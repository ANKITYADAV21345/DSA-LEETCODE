class Solution {
    public boolean isFreqSame(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;  // If s1 is longer than s2, it is impossible to have a permutation of s1 in s2.
        }

        int[] freq = new int[26];  // Frequency array for s1
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        int windSize = s1.length();
        int[] windowFreq = new int[26];  // Frequency array for the sliding window

        // Initialize the sliding window with the first 'windSize' characters of s2
        for (int i = 0; i < windSize; i++) {
            windowFreq[s2.charAt(i) - 'a']++;
        }

        // If the initial window matches the frequency of s1, return true
        if (isFreqSame(freq, windowFreq)) {
            return true;
        }

        // Now slide the window across s2
        for (int i = windSize; i < s2.length(); i++) {
            // Add the new character (i-th character in s2)
            windowFreq[s2.charAt(i) - 'a']++;

            // Remove the old character (i - windSize)-th character in s2
            windowFreq[s2.charAt(i - windSize) - 'a']--;

            // If at any point the frequencies match, return true
            if (isFreqSame(freq, windowFreq)) {
                return true;
            }
        }

        return false;  // No matching permutation found
    }
}
