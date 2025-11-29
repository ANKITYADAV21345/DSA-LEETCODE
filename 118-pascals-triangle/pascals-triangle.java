// pascal(i, j) = pascal(i-1, j-1) + pascal(i-1, j)

class Solution {
    Integer[][] memo;

    public List<List<Integer>> generate(int numRows) {
        memo = new Integer[numRows][numRows];
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(pascal(i, j));
            }
            result.add(row);
        }

        return result;
    }

    private int pascal(int i, int j) {
        // Base cases
        if (j == 0 || j == i)
            return 1;

        // Memo check
        if (memo[i][j] != null)
            return memo[i][j];

        // Recursive call + memo
        memo[i][j] = pascal(i - 1, j - 1) + pascal(i - 1, j);
        return memo[i][j];
    }
}


