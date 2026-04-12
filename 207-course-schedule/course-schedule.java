//apna college
class Solution {

    // DFS function to detect cycle
    public static boolean isCycleDFS(int src, boolean[] vis, boolean[] recPath, int[][] edges) {

        vis[src] = true;
        recPath[src] = true;

        for (int i = 0; i < edges.length; i++) {
            int v = edges[i][0];
            int u = edges[i][1];

            if (u == src) {

                if (!vis[v]) {
                    if (isCycleDFS(v, vis, recPath, edges)) {
                        return true;
                    }
                } else if (recPath[v]) {
                    return true;
                }
            }
        }

        recPath[src] = false;
        return false;
    }

    public boolean canFinish(int n, int[][] edges) {

        boolean[] vis = new boolean[n];
        boolean[] recPath = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (isCycleDFS(i, vis, recPath, edges)) {
                    return false;
                }
            }
        }

        return true;
    }
}