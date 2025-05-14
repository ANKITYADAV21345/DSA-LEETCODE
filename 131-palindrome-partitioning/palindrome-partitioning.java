import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> res = new ArrayList<>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        recur(s, 0, new ArrayList<>());
        return res;
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public void recur(String s, int partIndex, List<String> sublist) {
        // Base case
        if (partIndex == n) {
            res.add(new ArrayList<>(sublist));
            return;
        }
        // Explore the possibilities
        for (int end = partIndex; end < n; end++) {
            if (isPalindrome(s, partIndex, end)) { // <-- Fixed here
                // Add to list
                sublist.add(s.substring(partIndex, end + 1));
                // Explore
                recur(s, end + 1, sublist);
                // Backtrack
                sublist.remove(sublist.size() - 1);
            }
        }
    }
}
