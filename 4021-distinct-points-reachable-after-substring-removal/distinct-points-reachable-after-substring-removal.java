//study placement
class Solution {
    public int distinctPoints(String s, int k) {
        int n = s.length();
        int x[] = new int[n+1];
        int y[] = new int[n+1];

        for (int i = 0; i < n; i++) {
            x[i+1] = x[i];
            y[i+1] = y[i];

            if (s.charAt(i) == 'U') {
                y[i+1]++;
            } else if (s.charAt(i) == 'L') {
                x[i+1]--;
            } else if (s.charAt(i) == 'R') {
                x[i+1]++;
            } else if (s.charAt(i) == 'D') {
                y[i+1]--;
            }
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i <= n-k; i++) {
            int newX = x[i] + (x[n] - x[i+k]);
            int newY = y[i] + (y[n] - y[i+k]);
            String str = newX + "," + newY;
            set.add(str);
        }
        return set.size();
    }
}