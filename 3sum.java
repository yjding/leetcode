import java.util.Arrays;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(num.length<3) return results;
        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++){
            if(i>0&&num[i]==num[i-1]) continue;
            int target = -num[i];
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
}
