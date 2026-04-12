//apna college

class Solution {

    // Cycle Detection DFS
    public static boolean isCycleDFS(int src, boolean[] vis, boolean[] recPath, int[][] edges) {

        vis[src] = true;
        recPath[src] = true;

        for (int i = 0; i < edges.length; i++) {
            int v = edges[i][0];
            int u = edges[i][1];

            if (src == u) {

                if (!vis[v]) {
                    if (isCycleDFS(v, vis, recPath, edges)) {
                        return true;
                    }
                } else if (recPath[v]) { // BACK EDGE → cycle
                    return true;
                }
            }
        }

        recPath[src] = false;
        return false;
    }

    // Topological Sort DFS
    public static void topoOrder(int src, boolean[] vis, Stack<Integer> s, int[][] edges) {

        vis[src] = true;

        for (int i = 0; i < edges.length; i++) {
            int v = edges[i][0];
            int u = edges[i][1];

            if (src == u) {
                if (!vis[v]) {
                    topoOrder(v, vis, s, edges);
                }
            }
        }

        s.push(src);
    }

    public int[] findOrder(int n, int[][] edges) {

        boolean[] vis = new boolean[n];
        boolean[] recPath = new boolean[n];

        ArrayList<Integer> ans = new ArrayList<>();

        // Step 1: Cycle check
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (isCycleDFS(i, vis, recPath, edges)) {
                    return new int[0]; // empty if cycle
                }
            }
        }

        // Step 2: Topological Sort
        Stack<Integer> s = new Stack<>();

        Arrays.fill(vis, false); // vis.assign(n,false)

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                topoOrder(i, vis, s, edges);
            }
        }

        // Step 3: Stack → Answer
        while (!s.isEmpty()) {
            ans.add(s.pop());
        }

        // convert to array
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}