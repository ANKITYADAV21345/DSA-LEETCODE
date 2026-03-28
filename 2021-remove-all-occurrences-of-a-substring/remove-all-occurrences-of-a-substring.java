// Yeh code string s me se repeatedly substring part ko remove karta hai. Hum ek StringBuilder (result) use karte hain aur s ke har character ko ek-ek karke usme add karte hain. Har addition ke baad check karte hain ki result ke last m characters (m = part.length()) kya part ke equal hain. Agar equal mil jaata hai, toh us last wale part ko delete kar dete hain. Is tarah hum left-to-right build karte hue turant match milte hi remove karte rehte hain, aur finally result me wahi string bachi hoti hai jisme part ka koi occurrence nahi hota.


class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder result=new StringBuilder();

        int m=part.length();
        for(char ch:s.toCharArray()){
            result.append(ch);

            if(result.length()>=m){
                if(result.substring(result.length()-m).equals(part)){
                    result.delete(result.length()-m,result.length());
                }
            }
        }
        return result.toString();
    }
}