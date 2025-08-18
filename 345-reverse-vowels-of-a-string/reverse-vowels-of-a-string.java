class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        String vowels = "aeiouAEIOU";

        while (i < j) {
            // Find the next vowel from the start
            while (i < j && vowels.indexOf(arr[i]) == -1) {
                i++;
            }
            // Find the next vowel from the end
            while (i < j && vowels.indexOf(arr[j]) == -1) {
                j--;
            }
            // Swap the vowels
            if (i < j) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        return new String(arr);
    }
}
