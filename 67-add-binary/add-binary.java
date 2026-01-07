class Solution {
    public String addBinary(String a, String b) {
        // Binary strings ke lengths ko track karne ke liye indices
        int n1 = a.length() - 1;
        int n2 = b.length() - 1;
        // Carry aur base initialize karte hain
        int c = 0, base = 2;
        // Result ko store karne ke liye StringBuilder
        StringBuilder res = new StringBuilder();
        
        // Jab tak dono strings ke indices valid hain, loop chalayenge
        while (n1 >= 0 || n2 >= 0) {
            // Temporary variables for current bits
            int t1 = 0, t2 = 0;
            int sum;
            
            // Agar string 'a' ke current index valid hai, toh uska bit fetch karenge
            if (n1 >= 0)
                t1 = a.charAt(n1--) - '0';
            
            // Agar string 'b' ke current index valid hai, toh uska bit fetch karenge
            if (n2 >= 0)
                t2 = b.charAt(n2--) - '0';
            
            // Sum calculate karenge (bits ko add karna + carry)
            sum = t1 + t2 + c;
            
            // Agar sum base (2) se zyada ya barabar hai, carry set karenge aur sum adjust karenge
            if (sum >= base) {
                c = 1;
                sum = sum - base;
            } else {
                c = 0;
            }
            
            // Result ko append karenge
            res.append(sum);
        }  
        
        // Agar last mein carry bach gaya hai, toh result mein append karenge
        if (c == 1)
            res.append(c);

        // Result ko reverse karke return karenge kyunki humne bits ko reverse order mein append kiya hai
        return res.reverse().toString();
    }
}
