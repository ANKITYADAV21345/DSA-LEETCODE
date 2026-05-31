class Solution {
    public String reverseWords(String s) {
        return Arrays.stream(s.split(" "))     //split ion the bases of space  then wrap the array in a stream
                .map(word -> new StringBuilder(word).reverse().toString()) //wrap in stringbuilter reverse the string
                .collect(Collectors.joining(" "));  ///join on the bases of space
    }
}