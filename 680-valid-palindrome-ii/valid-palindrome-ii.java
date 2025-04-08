class Solution {
    // Method to check if a substring is a palindrome
    private boolean isPalindrome(String s, int left, int right) {
        // Jab tak left index right se chhota hai
        while (left < right) {
            // Agar left aur right index ke characters match nahi karte
            if (s.charAt(left) != s.charAt(right)) {
                // To yeh substring palindrome nahi hai
                return false;
            }
            // Characters match kar rahe hain, to next positions pe move karo
            left++;
            right--;
        }
        // Agar sab characters match ho gaye hain, to yeh palindrome hai
        return true;
    }

    // Main method to check if the string can be a palindrome by removing at most one character
    public boolean validPalindrome(String s) {
        // Start karte hain from the beginning and end of the string
        int i = 0;
        int j = s.length() - 1;

        // Jab tak i aur j overlap nahi karte
        while (i < j) {
            // Agar characters match karte hain
            if (s.charAt(i) == s.charAt(j)) {
                // To aage badho, i ko increment karo aur j ko decrement karo
                i++;
                j--;
            } else {
                // Agar characters match nahi karte, to do possibilities check karo:
                // 1. i ke character ko ignore karke check karo
                // 2. j ke character ko ignore karke check karo
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }
        // Agar loop complete hota hai bina mismatch ke, to string palindrome hai
        return true;
    }
}
