import java.util.Hashtable;
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        Hashtable<String, ArrayList<String>> map = new Hashtable<String, ArrayList<String>>();
        ArrayList<String> results = new ArrayList<String>();
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);
            if(!map.containsKey(sortedStr)) map.put(sortedStr, new ArrayList<String>());
            map.get(sortedStr).add(str);
        }
        for(Iterator<ArrayList<String>> iter=map.values().iterator();iter.hasNext();){
            ArrayList<String> list = iter.next();
            if(list.size()>1) results.addAll(list); 
        }
        return results;
    }
}
