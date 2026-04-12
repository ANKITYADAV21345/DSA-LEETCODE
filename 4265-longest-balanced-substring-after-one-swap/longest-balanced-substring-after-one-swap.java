//beastcodes
//contest 497 q3

class Solution {

    public static int solve(String s) {
        int n = s.length();

        int totalzero = 0, totalone = 0, maxi = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') totalzero++;
            else totalone++;
        }

        mp.put(0, -1);

        int zero = 0, one = 0;

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '0') zero++;
            else one++;

            int diff = one - zero;

            if (!mp.containsKey(diff)) {
                mp.put(diff, i);
            } else {
                int len = i - mp.get(diff);
                maxi = Math.max(maxi, len);
            }

            int diff1 = diff + 2;   // 0 -> 1
            int diff2 = diff - 2;   // 1 -> 0

            if ((totalone - one > 0) && mp.containsKey(diff1)) {
                int ind = mp.get(diff1);
                int len = i - ind;
                maxi = Math.max(maxi, len);
            }

            if ((totalzero - zero > 0) && mp.containsKey(diff2)) {
                int ind = mp.get(diff2);
                int len = i - ind;
                maxi = Math.max(maxi, len);
            }
        }

        return maxi;
    }

    public int longestBalanced(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        int ans1 = solve(s);
        int ans2 = solve(rev);

        return Math.max(ans1, ans2);
    }
}