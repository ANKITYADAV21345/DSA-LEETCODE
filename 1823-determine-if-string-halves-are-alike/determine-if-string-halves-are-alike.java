class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int j = n / 2;
        int count1 = 0, count2 = 0;
        String vowels = "aeiouAEIOU";
        
        for (int i = 0; i < n / 2; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j + i); 
            if (vowels.indexOf(ch1) != -1)
                count1++;
            if (vowels.indexOf(ch2) != -1)
                count2++;
        }
        
        return count1 == count2;
    }
}
