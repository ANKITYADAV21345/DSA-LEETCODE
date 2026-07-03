//code story with mik

//how to find ith bit of a number 
//(num>>i) & 1=1

//how to unset the right most set bit of an integer
//n=(n &(-1));



// Approach-1 (Using simple right shift operator)
// T.C : O(1) - because the loop in the code iterates 32 times, which is a constant number regardless of the input n
// S.C : O(1)
class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        for (int i = 31; i >= 0; i--) {
            if (((n >> i) & 1) == 1) {
                count++;
            }
        }

        return count;
    }
}