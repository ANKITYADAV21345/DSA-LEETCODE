class Solution {
    public String sortVowels(String s) {
        char[] result=s.toCharArray();
        char[] temp=new char[s.length()];
        int k=0,j=0;
        for(int i=0;i<s.length();i++){
            if(result[i]=='A'||result[i]=='E'||result[i]=='I'|| result[i]=='O'||result[i]=='U'||
                result[i]=='a'|| result[i]=='e'||result[i]=='i'||result[i]=='o'||result[i]=='u'){
                    temp[k++]=result[i];
                }
        }
        Arrays.sort(temp,0,k);
        //values update kr rahe hai
        StringBuilder ans=new StringBuilder();
        for(char c:result){
            if(c=='A'||c=='E'||c=='I'|| c=='O'||c=='U'||
                c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                    ans.append(temp[j]);
                    j++;
            }
            else{
                ans.append(c);
            }
        }
        return ans.toString();
    }
}