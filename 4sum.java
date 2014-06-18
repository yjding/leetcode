import java.util.Arrays;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num, int start, int sum) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(num.length-start<3) return results;
        for(int i=start;i<num.length-2;i++){
            if(i>start&&num[i]==num[i-1]) continue;
            int target = sum-num[i];
            int j=i+1, k=num.length-1;
            while(j<k){
                if(j>i+1&&num[j]==num[j-1]){
                    j++;
                    continue;
                }
                if(num[j]+num[k]>target){
                    k--;
                }
                else if(num[j]+num[k]<target){
                    j++;
                }
                else{
                    ArrayList<Integer> result = new ArrayList<Integer>();
                    result.add(num[i]);
                    result.add(num[j]);
                    result.add(num[k]);
                    results.add(result);
                    j++;
                }
            }
        }
        return results;
    }
    
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for(int i=0;i<num.length-3;i++){
            if(i>0&&num[i]==num[i-1]) continue;
            ArrayList<ArrayList<Integer>> result = threeSum(num, i+1, target-num[i]);
            if(result.size()==0) continue;
            else{
                for(int j=0;j<result.size();j++){
                    result.get(j).add(0, num[i]);
                    results.add(result.get(j));
                }
            }
        }
        return results;
    }
}
