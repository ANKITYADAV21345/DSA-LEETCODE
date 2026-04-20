//apna college article  brute force
class Solution {
  public int lengthOfLongestSubstring(String s) {
      int maxLength = 0;




      for (int i = 0; i < s.length(); i++) {  // Start of substring
          HashSet<Character> charSet = new HashSet<>();
          for (int j = i; j < s.length(); j++) {  // End of substring
              if (charSet.contains(s.charAt(j))) {  // Duplicate found, break
                  break;
              }
              charSet.add(s.charAt(j));  // Add character to set
              maxLength = Math.max(maxLength, j - i + 1);  // Update max length
          }
      }
      return maxLength;
  }
}
