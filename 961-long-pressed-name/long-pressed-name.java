class Solution {
    public boolean isLongPressedName(String name, String typed) {
        // Name aur Typed ki length ko store kar lete hain
        int n1 = name.length();
        int n2 = typed.length();
        // Dono strings ke indexes ko initialize karte hain
        int idx1 = 0, idx2 = 0;
        
        // Jab tak dono indexes valid hain, loop chalta hai
        while (idx1 < n1 && idx2 < n2) {
            // Agar dono strings ka current character match karta hai
            if (name.charAt(idx1) == typed.charAt(idx2)) {
                idx1++; // Name ke index ko aage badhate hain
                idx2++; // Typed ke index ko aage badhate hain
                continue; // Loop ke agle iteration pe chale jate hain
            }
            
            // Agar current character match nahi karta, par name ka previous character match karta hai
            if (idx1 > 0 && name.charAt(idx1 - 1) == typed.charAt(idx2)) {
                idx2++; // Typed ke index ko aage badhate hain
            } else {
                // Agar nahi match karta, to return false
                return false;
            }
        }
        
        // Agar name ke index ab bhi chhoda hua hai, to matlab name ka pura content match nahi hua
        if (idx1 < n1) {
            return false;
        }
        
        // Jo bhi characters typed me bach gaye hain, wo last character se match hona chahiye
        while (idx2 < n2) {
            if (name.charAt(n1 - 1) != typed.charAt(idx2)) {
                return false; // Agar last character se match nahi karta, to return false
            }
            idx2++; // Typed ke index ko aage badhate hain
        }
        
        // Agar sab checks pass kar gaye, to return true
        return true;
    }
}
