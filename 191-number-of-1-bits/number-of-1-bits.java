//code story with mik
// Approach-3 (Using simple bit magic)
// T.C : O(log(n)) -> In each iteration, n is divided by 2 (n /= 2)
// S.C : O(1)
class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            count += (n % 2);
            n /= 2;
        }

        return count;
    }
}