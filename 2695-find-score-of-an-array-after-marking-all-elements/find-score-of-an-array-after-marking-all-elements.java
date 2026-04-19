//codestorywithmik
//aproach 1

public class Solution {

    public static long findScore(int[] nums) {

        int n = nums.length;

        // vector<pair<int,int>> vec;
        int[][] vec = new int[n][2];

        for (int i = 0; i < n; i++) {
            vec[i][0] = nums[i];
            vec[i][1] = i;
        }

        // sort(begin(vec), end(vec));
        Arrays.sort(vec, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        long score = 0;

        // vector<bool> visited(n, false);
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {

            int element = vec[i][0];
            int idx = vec[i][1];

            if (visited[idx] == false) {

                visited[idx] = true;
                score += element;   

                if (idx - 1 >= 0 && visited[idx - 1] == false) {
                    visited[idx - 1] = true;
                }

                if (idx + 1 < n && visited[idx + 1] == false) {
                    visited[idx + 1] = true;
                }
            }
        }

        return score;
    }

    public static void main(String[] args) {

        int[] nums = {2, 1, 3, 4, 5, 2};

        long ans = findScore(nums);

        System.out.println("Score: " + ans);
    }
}