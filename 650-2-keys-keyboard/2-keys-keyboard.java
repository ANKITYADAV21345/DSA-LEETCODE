//this aproach is giving TLE
//codebix
// class Solution {
//     public int minSteps(int n) {
//         int current = 1;
//         int count = 0;
//         int buffer = 0;
//         while (current < n) {
//             int rest = n - current;

//             if (rest % current == 0) {
//                 buffer = current;
//                 current = current + buffer;
//                 count = count + 2;
//             } else {
//                 count = count + buffer;
//                 count++;
//             }
//         }
//         return count;
//     }
// }




// Use Prime Factorization. For each factor of n, the best we can do is "copy" and "paste" that factor times.

// Why this works:
// If n is divisible by i, then it means you can get to n by copying at n/i and pasting i times.

// This is the minimal step approach because each factor corresponds to a "Copy All" + multiple "Pastes".
class Solution {
    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }
}



