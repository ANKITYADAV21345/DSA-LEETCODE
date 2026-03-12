//khud se kiya hai
import java.util.*;
class Solution {
    public String maximumOddBinaryNumber(String s) {
        char arr[]=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        int count=0;
        for(int i=0;i<s.length();i++){
            if(arr[i]=='1'){
                count++;
            }
        }

        Arrays.fill(arr, '0');

        if(count>=1){
            arr[s.length()-1]='1';
            count--;
        }

        int i=0;
        while(count>0){
            arr[i]='1';
            count--;
            i++;
        }

        for(int j=0;j<arr.length;j++){
            sb.append(arr[j]);
        }
        return sb.toString();

    }
}