class Solution {
    public String reversePrefix(String word, char ch) {
        // `ch` character ke pehle occurrence ka index dhoondhna
        int idx = word.indexOf(ch);
        
        // Agar `ch` character nahi milta, toh original word hi return karo
        if (idx == -1) {
            return word;
        }

        // Word ke start se lekar `ch` tak ke substring ko reverse karna
        StringBuilder sb = new StringBuilder(word.substring(0, idx + 1)).reverse();

        // Agar `ch` ke baad bhi kuch characters hain, unhe append karna
        if (idx + 1 < word.length()) {
            sb.append(word.substring(idx + 1));
        }
        
        // Final result ko string mein convert karke return karna
        return sb.toString();
    }
}
