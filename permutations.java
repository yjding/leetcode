public class Solution {
    void permuteRecursive(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result, ArrayList<Integer> candidates, int gap){
        if(gap==0){
            ArrayList<Integer> copyResult = new ArrayList<Integer>(result);
            results.add(copyResult);
            return;
        }
        for(int i=0;i<candidates.size();i++){
            Integer e = candidates.remove(i);
            result.add(e);
            permuteRecursive(results, result, candidates, gap-1);
            e = result.remove(result.size()-1);
            candidates.add(i, e);
        }
        return;
    }

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> candidates = new ArrayList<Integer>();
        for(int i=0;i<num.length;i++){
            candidates.add(new Integer(num[i]));
        }
        permuteRecursive(results, result, candidates, num.length);
        return results;
    }
}
