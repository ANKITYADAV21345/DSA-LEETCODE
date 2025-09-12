class Solution {
    public String sortVowels(String s) {
        char[] result=s.toCharArray();
        char[] temp=new char[s.length()];
        HashSet<Character> vowels= new HashSet<>(Arrays.asList('A','E','I','O','U','a','e','i','o','u'));
        int k=0,j=0;
        for(char c:result){
            if(vowels.contains(c)){
                    temp[k++]=c;
                }
        }
        Arrays.sort(temp,0,k);
        //values update kr rahe hai
        StringBuilder ans=new StringBuilder();
        for(char c:result){
            if(vowels.contains(c)){
                    ans.append(temp[j++]);
            }
            else{
                ans.append(c);
            }
        }
        return ans.toString();
    }
}