//PEPCODING

class TreeAncestor {

    static int MAX = 17; // enough for n <= 10^5
    int[][] table;

    public TreeAncestor(int n, int[] parent) {
        table = new int[MAX][n];

        // base case (2^0 parent)
        for (int i = 0; i < n; i++) {
            table[0][i] = parent[i];
        }

        // build binary lifting table
        for (int i = 1; i < MAX; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i - 1][j] == -1) {
                    table[i][j] = -1;
                } else {
                    table[i][j] = table[i - 1][table[i - 1][j]];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {

        for (int i = 0; i < MAX; i++) {
            int mask = (1 << i);

            if ((k & mask) != 0) {
                node = table[i][node];

                if (node == -1) {
                    return -1;
                }
            }
        }

        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */