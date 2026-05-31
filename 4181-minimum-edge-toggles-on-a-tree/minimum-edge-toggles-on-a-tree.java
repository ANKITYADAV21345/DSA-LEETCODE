//rajan keshari

class Solution {

    List<int[]> res;
    List<List<int[]>> adj;
    int[] diff;

    void dfs(int u, int p) {
        for (int[] edge : adj.get(u)) {
            int v = edge[0];
            int idx = edge[1];

            if (v == p) continue;

            dfs(v, u); // bottom up

            if (diff[v] != 0) {
                res.add(new int[]{idx});

                diff[v] ^= 1; // 0->1, 1->0
                diff[u] ^= 1;
            }
        }
    }

    public List<Integer> minimumFlips(int n, int[][] edges, String start, String target) {

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(new int[]{v, i});
            adj.get(v).add(new int[]{u, i});
        }

        diff = new int[n];
        int s = 0;

        for (int i = 0; i < n; i++) {
            if (start.charAt(i) != target.charAt(i)) {
                diff[i] = 1;
                s++;
            }
        }

        if ((s & 1) == 1) {
            return Arrays.asList(-1);
        }

        res = new ArrayList<>();
        dfs(0, -1);

        for (int i = 0; i < n; i++) {
            if (diff[i] != 0) {
                return Arrays.asList(-1);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int[] x : res) {
            ans.add(x[0]);
        }

        Collections.sort(ans);
        return ans;
    }
}