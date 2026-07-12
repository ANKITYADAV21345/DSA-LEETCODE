//code bix ke unique path 1 vala aproach lagaya and last col and last row 
//ke teeno case jo iss question ke according the vo handle kiye 

class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // Agar destination hi blocked hai to koi path possible nahi
        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        int[][] dp = new int[m][n];

        // -------- Fill Last Column --------
        // Sirf niche move kar sakte hain.
        // Obstacle mila to uske upar wale sab cells bhi 0 ho jayenge.
        for (int i = m - 1; i >= 0; i--) {

            if (obstacleGrid[i][n - 1] == 1)
                dp[i][n - 1] = 0;          // agar ith cel pe pathar hai to uske uper vale sel target tak nahi pahuch sakte 

            else if (i == m - 1)
                dp[i][n - 1] = 1;          // last index se last index pe pahuchne ka 1 tarika hi hota hai

            else
                dp[i][n - 1] = dp[i + 1][n - 1];   // Neeche vale cell ke barabar possible ways 
        }

        // -------- Fill Last Row --------
        // Sirf right move kar sakte hain.
        // Obstacle mila to uske left wale sab cells bhi 0 ho jayenge.
        for (int j = n - 1; j >= 0; j--) {

            if (obstacleGrid[m - 1][j] == 1)
                dp[m - 1][j] = 0;          // agar ith cel pe pathar hai to uske left vale sel target tak nahi pahuch sakte 

            else if (j == n - 1)
                dp[m - 1][j] = 1;          // Destination

            else
                dp[m - 1][j] = dp[m - 1][j + 1];   //  right vale cell ke barabar possible ways 
        }

        // -------- Fill Remaining Cells --------
        // Path = Down + Right
        // Obstacle hai to path = 0
        for (int i = m - 2; i >= 0; i--) {

            for (int j = n - 2; j >= 0; j--) {

                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;

                else
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }

        return dp[0][0];
    }
}