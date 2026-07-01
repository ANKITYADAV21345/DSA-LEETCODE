//universitycore instagram
class Solution {
    public boolean detectCapitalUse(String word) {
        int uppercase=0;
        for(int i=0;i<word.length();i++){
            if(Character.isUpperCase(word.charAt(i))){
                uppercase++;
            }
        }
        if(uppercase==word.length()||uppercase==0||(uppercase==1 && Character.isUpperCase(word.charAt(0)))){
            return true;
        }
        else{
            return false;
        }
    }
}