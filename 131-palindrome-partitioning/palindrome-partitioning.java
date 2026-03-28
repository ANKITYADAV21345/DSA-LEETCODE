//apna college

// check palindrome
class Solution{
    public static boolean isPalin(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    // backtracking
    public static void getAllParts(String s, List<String> partitions,               List<List<String>> ans) {

        if (s.length() == 0) {
            ans.add(new ArrayList<>(partitions));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String part = s.substring(0, i + 1);

            if (isPalin(part)) {
                partitions.add(part);
                getAllParts(s.substring(i + 1), partitions, ans);
                partitions.remove(partitions.size() - 1); // backtrack
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> partitions = new ArrayList<>();

        getAllParts(s, partitions, ans);
        return ans;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = partition(s);

        for (List<String> list : result) {
            System.out.println(list);
        }
    }
}