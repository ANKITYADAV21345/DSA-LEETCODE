//study placement
class Solution {
    public String majorityFrequencyGroup(String s) {
        int freq[] = new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        int key = 0; int max = 0;
        Map<Integer, Set<Character>> map = new HashMap<>();
        for(int i=0; i<26; i++){
            if(freq[i]==0) continue;
            map.putIfAbsent(freq[i], new HashSet<>());
            char ch = (char)(i+'a');
            map.get(freq[i]).add(ch);
            if(map.get(freq[i]).size() > max){
                key = freq[i];
                max = map.get(freq[i]).size();
            }
            else if(map.get(freq[i]).size() == max){
                if(key < freq[i]){
                    key = freq[i];
                }
            } 
        }
        Set<Character> finalSet = map.get(key);
        StringBuilder sb = new StringBuilder();
        for(char c : finalSet){
            sb.append(c);
        }
        return sb.toString();
    }
}