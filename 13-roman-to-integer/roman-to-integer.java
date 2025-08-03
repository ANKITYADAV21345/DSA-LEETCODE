class Solution {
    // Helper method to convert Roman numeral characters to their integer values
    private int getVal(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public int romanToInt(String s) {
        int n = s.length();
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            // Get the value of the current Roman numeral character
            int currentVal = getVal(s.charAt(i));
            
            // Check if this is not the last character and the next character has a higher value
            if (i + 1 < n && getVal(s.charAt(i + 1)) > currentVal) {
                sum -= currentVal; // Subtract the current value
            } else {
                sum += currentVal; // Add the current value
            }
        }
        
        return sum;
    }
}
