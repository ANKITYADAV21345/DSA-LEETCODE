import java.util.*;
class Solution {
    HashSet<String> set;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result=new ArrayList<>();
        if(words==null || words.length==0){
            return result;
        }
        set=new HashSet<>(Arrays.asList(words));
        for(String word : words){
            if(word.length()==0){
                continue;
            }
            set.remove(word);
            if(isconcat(word)){
                result.add(word);
            }
            set.add(word);
        }
        return result;
    }

    public boolean isconcat(String words){
        int len=words.length();
        boolean dp[]=new boolean[len+1];
        dp[0]=true;
        for(int i=1;i<=len;i++){
            for(int j=0;j<i;j++){
                if (dp[j] && set.contains(words.substring(j, i))) {

                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[len];
    }
}