//done by my own
import java.util.*;
class Solution {
    public long sumAndMultiply(int n) {
        String s=String.valueOf(n);
        StringBuilder sb=new StringBuilder();

        int digitSum=0;
        for(char c:s.toCharArray()){
            if(c!='0'){
                sb.append(c);
                digitSum=digitSum+c-'0';
            }
        }

        if(sb.length()==0) return 0;

        long x=Integer.parseInt(sb.toString());
        return x*digitSum;
    }
}