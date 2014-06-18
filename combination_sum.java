import java.util.Arrays;
public class Solution {
    void combinationSumRecursive(int[] candidates, int startIndex, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result, int gap){
        if(gap==0){
            ArrayList<Integer> copyResult = new ArrayList<Integer>(result);
            results.add(copyResult);
            return;
        }
        if(candidates[startIndex]>gap) return;
        for(int i=startIndex;i<candidates.length;i++){
            result.add(candidates[i]);
            combinationSumRecursive(candidates, i, results, result, gap-candidates[i]);
            result.remove(result.size()-1);
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        combinationSumRecursive(candidates, 0, results, result, target);
        return results;
    }
}
