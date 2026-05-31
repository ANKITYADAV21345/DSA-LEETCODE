//samrat bhardwaj atlasian
class Solution {

    int[] par;

    int findPar(int u) {
        if (par[u] == u) {
            return u;
        }

        return par[u] = findPar(par[u]);
    }

    public long maxAlternatingSum(int[] nums, int[][] swaps) {

        int n = nums.length;

        par = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
        }

        for (int[] swap : swaps) {

            int p1 = findPar(swap[0]);
            int p2 = findPar(swap[1]);

            if (p1 != p2) {
                par[p2] = p1;
            }
        }

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int p = findPar(i);

            if (!map.containsKey(p)) {
                map.put(p, new ArrayList<>());
            }

            map.get(p).add(nums[i]);
        }

        int[][] pos = new int[n][2];

        for (int i = 0; i < n; i++) {

            if (par[i] == i) {

                Collections.sort(map.get(i));

                pos[i][0] = 0;
                pos[i][1] = map.get(i).size() - 1;
            }
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {

            int p = par[i];

            ArrayList<Integer> al = map.get(par[i]);

            if (i % 2 == 0) {

                sum += al.get(pos[p][1]);
                pos[p][1]--;

            } else {

                sum -= al.get(pos[p][0]);
                pos[p][0]++;
            }
        }

        return sum;
    }
}