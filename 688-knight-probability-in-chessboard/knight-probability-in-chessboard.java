//codebix
import java.util.HashMap;

class Solution {
    private int[][] dir = {
        { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 },
        { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }
    };

    private HashMap<String, Double> hm = new HashMap<>();

    public double knightProbability(int n, int k, int row, int column) {
        return find(n, k, row, column);
    }

    private double find(int n, int k, int row, int column) {
        if (!isValid(row, column, n)) return 0;
        if (k == 0) return 1;

        String key = row + "," + column + "," + k;
        if (hm.containsKey(key)) return hm.get(key);

        double probability = 0;

        for (int i = 0; i < dir.length; i++) {
            int newRow = row + dir[i][0];
            int newCol = column + dir[i][1];
            probability += find(n, k - 1, newRow, newCol) / 8.0;
        }

        hm.put(key, probability);
        return probability;
    }

    private boolean isValid(int row, int column, int n) {
        return row >= 0 && row < n && column >= 0 && column < n;
    }
}