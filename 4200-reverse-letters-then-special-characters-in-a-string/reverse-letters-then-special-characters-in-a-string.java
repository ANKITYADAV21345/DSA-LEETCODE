import java.util.*;

class Solution {

    public boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    public String reverseByType(String s) {

        List<Character> letters = new ArrayList<>();
        List<Character> special = new ArrayList<>();

        // collect
        for (char c : s.toCharArray()) {
            if (isLetter(c)) letters.add(c);
            else special.add(c);
        }

        // reverse
        Collections.reverse(letters);
        Collections.reverse(special);

        StringBuilder ans = new StringBuilder();

        int i = 0, j = 0;

        for (char c : s.toCharArray()) {
            if (isLetter(c)) ans.append(letters.get(i++));
            else ans.append(special.get(j++));
        }

        return ans.toString();
    }
}

