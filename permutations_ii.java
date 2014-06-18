import java.util.Arrays;
public class Solution {
    void permuteRecursive(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result, ArrayList<Integer> candidates, int gap){
        if(gap==0){
            ArrayList<Integer> copyResult = new ArrayList<Integer>(result);
            results.add(copyResult);
            return;
        }
        for(int i=0;i<candidates.size();i++){
            if(i>0&&candidates.get(i).equals(candidates.get(i-1))) continue;
            Integer e = candidates.remove(i);
            result.add(e);
            permuteRecursive(results, result, candidates, gap-1);
            e = result.remove(result.size()-1);
            candidates.add(i, e);
        }
        return;
    }

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> candidates = new ArrayList<Integer>();
        Arrays.sort(num);
        for(int i=0;i<num.length;i++){
            candidates.add(new Integer(num[i]));
        }
        permuteRecursive(results, result, candidates, num.length);
        return results;
    }
}
