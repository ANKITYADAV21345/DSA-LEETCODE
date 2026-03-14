// 14/3/2026 daily question



// valid            //invalid
// aba              //aaa
// abc              //abb
// aca              //bcc
// acb
// bab
// bac
// bca
// bcb
// cab
// cac
// cba
// cbc


// n → string ki length
// k → kth string chahiye
import java.util.*;

class Solution {

    List<String> list = new ArrayList<>();

    public String getHappyString(int n, int k) {

        char[] letters = {'a','b','c'};
        backtrack(n, letters, new StringBuilder());

        if(k > list.size()){
            return "";
        }

        return list.get(k-1);
    }

    public void backtrack(int n, char[] letters, StringBuilder sb){

        if(sb.length() == n){
            list.add(sb.toString());
            return;
        }

        for(int i=0;i<letters.length;i++){
            //same character skip
            if(sb.length()>0 && sb.charAt(sb.length()-1)==letters[i]){
                continue;
            }
            else{
                //add leter in string
                sb.append(letters[i]);
                backtrack(n,letters,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}