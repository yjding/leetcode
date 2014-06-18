import java.util.Arrays;
public class Solution {
    void combinationSum2Recursive(int[] candidates, int startIndex, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result, int gap){
        if(gap==0){
            ArrayList<Integer> copyResult = new ArrayList<Integer>(result);
            results.add(copyResult);
            return;
        }
        if(startIndex>=candidates.length||candidates[startIndex]>gap) return;
        int previous = -1;
        for(int i=startIndex;i<candidates.length;i++){
            if(candidates[i]==previous) continue;
            previous = candidates[i];
            result.add(candidates[i]);
            combinationSum2Recursive(candidates, i+1, results, result, gap-candidates[i]);
            result.remove(result.size()-1);
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        combinationSum2Recursive(candidates, 0, results, result, target);
        return results;
    }
}
