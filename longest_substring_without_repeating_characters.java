import java.util.Hashtable;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
         Hashtable<Character, Integer> map = new Hashtable<Character, Integer>(100);
        int i=0, j=0, len=0;
        while(j<s.length()){
            if(map.containsKey(s.charAt(j))){
                int next = map.get(s.charAt(j))+1;
                while(i<next){
                    map.remove(s.charAt(i++));
                }
                map.put(s.charAt(j), j);
            }else{
                if(j-i+1>len){
                    len = j-i+1;
                }
                map.put(s.charAt(j), j);
            }
            j++;
        }
        return len;
    }
}
