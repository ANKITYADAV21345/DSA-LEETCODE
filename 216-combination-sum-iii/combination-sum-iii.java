//shash code 

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        recur(k, n, 1, cur, res); // Start from 1, not 0, because numbers are from 1 to 9
        return res;
    }

    public void recur(int k, int target, int start, ArrayList<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            if (target == 0) {
                res.add(new ArrayList<Integer>(cur)); // Corrected the syntax here
            }
            return;
        }

        for (int el = start; el <= 9; el++) {
            if (el > target) {
                break; // Prune branches early
            }
            cur.add(el);
            recur(k, target - el, el + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
