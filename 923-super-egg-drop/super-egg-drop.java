//codebix  
//binary search inside dp sir ne leniar search lagaya tha jo slow tha to gpt se binary sirch a[roach lagwai
class Solution {
    public int superEggDrop(int eggs, int floors) {
        int[][] dp = new int[eggs + 1][floors + 1];

        for (int e = 1; e <= eggs; e++) {
            for (int f = 1; f <= floors; f++) {
                if (e == 1) {
                    dp[e][f] = f; // Linear search when only 1 egg
                } else {
                    int low = 1, high = f;
                    int min = Integer.MAX_VALUE;

                    while (low <= high) {
                        int mid = (low + high) / 2;

                        int eggBreaks = dp[e - 1][mid - 1];   // Egg breaks → check below
                        int eggSurvives = dp[e][f - mid];     // Egg survives → check above

                        int worst = Math.max(eggBreaks, eggSurvives);
                        min = Math.min(min, worst + 1);

                        // Move towards the side which gives higher trials
                        if (eggBreaks > eggSurvives) {
                            high = mid - 1;
                        } else {
                            low = mid + 1;
                        }
                    }

                    dp[e][f] = min;
                }
            }
        }

        return dp[eggs][floors];
    }
}


//memoisation
// class Solution {
//     public int superEggDrop(int eggs, int floors, int[][] memo) {
//         if (eggs == 1)
//             return floors;

//         if (floors == 0 || eggs == 0)
//             return 0;

//         if (memo[eggs][floors] > 0)
//             return memo[eggs][floors];

//         int ans = Integer.MAX_VALUE;

//         for (int i = 1; i <= floors; i++) {
//             int trials_egg_break = superEggDrop(eggs - 1, i - 1, memo);
//             int trials_egg_survives = superEggDrop(eggs, floors - i, memo);

//             ans = Math.min(ans, Math.max(trials_egg_break, trials_egg_survives));
//         }

//         memo[eggs][floors] = ans + 1;
//         return ans + 1;
//     }

//     // Wrapper function to make the call easier
//     public int superEggDrop(int eggs, int floors) {
//         int[][] memo = new int[eggs + 1][floors + 1];
//         return superEggDrop(eggs, floors, memo);
//     }
// }

//recursion
// class Solution {
//     public int superEggDrop(int eggs, int floors) {

//         if (eggs == 1)
//             return floors;

//         if (floors == 1)
//             return 1;

//         if (floors == 0 || eggs == 0)
//             return 0;

//         int ans = Integer.MAX_VALUE;
//         for (int i = 1; i <= floors; i++) {

//             int trials_egg_break = superEggDrop(eggs - 1, i - 1);
//             int trials_egg_survives = superEggDrop(eggs, floors - i);

//             //best of worst or min of max
//             ans = Math.min(ans, Math.max(trials_egg_break, trials_egg_survives));
//         }
//         return ans + 1;
//     }
// }