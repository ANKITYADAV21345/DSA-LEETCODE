class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int n1 = word1.length();
        int n2 = word2.length();
        int i = 0;

        // Loop until we've processed all characters from both strings
        while (i < n1 || i < n2) {
            // Append character from word1 if available
            if (i < n1) {
                sb.append(word1.charAt(i));
            }
            // Append character from word2 if available
            if (i < n2) {
                sb.append(word2.charAt(i));
            }
            // Move to the next character
            i++;
        }

        return sb.toString();
    }
}
