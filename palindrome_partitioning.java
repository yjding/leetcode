public class Solution {
    Boolean isValid(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        if(s=="") return results;
        if(isValid(s)){
            ArrayList<String> tempList = new ArrayList<String>();
            tempList.add(s);
            results.add(tempList);
        }
        for(int i=1;i<s.length();i++){
            String head = s.substring(0, i), tail = s.substring(i);
            if(isValid(head)){
                ArrayList<ArrayList<String>> subResults = partition(tail);
                for(int j=0;j<subResults.size();j++){
                    subResults.get(j).add(0, head);
                }
                results.addAll(subResults);
            }else{
                continue;
            }
        }
        return results;
    }
}
