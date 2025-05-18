import java.util.*;

class Solution {
    public int minMoves(String[] matrix) {
        int rowCount = matrix.length;
        int columnCount = matrix[0].length();

        // Gather teleportation points
        List<int[]>[] teleportPositions = new List[26];
        for (int i = 0; i < 26; i++) {
            teleportPositions[i] = new ArrayList<>();
        }

        char[][] grid = new char[rowCount][columnCount];

        for (int i = 0; i < rowCount; i++) {
            grid[i] = matrix[i].toCharArray();
            for (int j = 0; j < columnCount; j++) {
                char cell = grid[i][j];
                if (cell >= 'A' && cell <= 'Z') {
                    teleportPositions[cell - 'A'].add(new int[]{i, j});
                }
            }
        }

        return solve(grid, teleportPositions);
    }

    // Solve using 0-1 BFS
    private int solve(char[][] grid, List<int[]>[] teleportPositions) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;

        if (grid[0][0] == '#' || grid[rowCount - 1][columnCount - 1] == '#') return -1;

        int[][] minSteps = new int[rowCount][columnCount];
        for (int[] row : minSteps) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        boolean[] portalUsed = new boolean[26];
        Deque<int[]> bfsQueue = new ArrayDeque<>();
        bfsQueue.addFirst(new int[]{0, 0});
        minSteps[0][0] = 0;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!bfsQueue.isEmpty()) {
            int[] current = bfsQueue.pollFirst();
            int x = current[0], y = current[1];
            int currentSteps = minSteps[x][y];

            if (x == rowCount - 1 && y == columnCount - 1) return currentSteps;

            char cellValue = grid[x][y];

            // Teleport if applicable
            if (cellValue >= 'A' && cellValue <= 'Z') {
                int portalIndex = cellValue - 'A';
                if (!portalUsed[portalIndex]) {
                    portalUsed[portalIndex] = true;
                    for (int[] portalTarget : teleportPositions[portalIndex]) {
                        int px = portalTarget[0], py = portalTarget[1];
                        if (currentSteps < minSteps[px][py]) {
                            minSteps[px][py] = currentSteps;
                            bfsQueue.offerFirst(new int[]{px, py}); // 0-cost move
                        }
                    }
                }
            }

            // Move to adjacent cells
            for (int[] dir : directions) {
                int newX = x + dir[0], newY = y + dir[1];
                if (newX >= 0 && newY >= 0 && newX < rowCount && newY < columnCount && grid[newX][newY] != '#') {
                    if (currentSteps + 1 < minSteps[newX][newY]) {
                        minSteps[newX][newY] = currentSteps + 1;
                        bfsQueue.offerLast(new int[]{newX, newY}); // 1-cost move
                    }
                }
            }
        }

        return -1; // Destination not reachable
    }
}
