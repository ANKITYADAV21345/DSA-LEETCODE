import java.util.Arrays;

class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int idx = 0; // index to place the characters in the modified array
        int i = 0;   // pointer to traverse the original array

        while (i < n) {
            char ch = chars[i];
            int count = 0;

            // Count the occurrences of the current character
            while (i < n && chars[i] == ch) {
                count++;
                i++;
            }

            // Place the character
            chars[idx++] = ch;

            // If the count is greater than 1, convert it to string and store each digit
            if (count > 1) {
                String countStr = Integer.toString(count);
                for (char digit : countStr.toCharArray()) {
                    chars[idx++] = digit;
                }
            }
        }

        // Return the length of the compressed array
        return idx;
    }
}
