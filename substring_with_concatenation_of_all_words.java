import java.util.Hashtable;
public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(L.length==0) return result;
        int l = L.length;
        int m = L[0].length();
        int n = S.length();
        if(n<l*m) return result;
        Hashtable<String, Integer> map = new Hashtable<String, Integer>();
        for(int k=0;k<l;k++){
            if(!map.containsKey(L[k])) map.put(L[k], 1);
            else{
                int count = map.get(L[k]);
                map.put(L[k], count+1);
            }
        }
        for(int i=0;i<=n-l*m;i++){
            Hashtable<String, Integer> cloneMap = (Hashtable<String, Integer>)map.clone(); 
            int j=0;
            for(;j<l;j++){
                String s = S.substring(i+m*j, i+m*j+m);
                if(!cloneMap.containsKey(s)) break;
                else{
                    int count = cloneMap.get(s);
                    if(count-1<0) break;
                    else cloneMap.put(s, count-1);
                }
            }
            if(j==l) result.add(i);
        }
        return result;
    }
}
