import java.util.HashSet;
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] results = new int[2];
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<numbers.length;i++) set.add(numbers[i]);
        for(int i=0;i<numbers.length;i++){
            if(set.contains(target-numbers[i])){
                for(int j=i+1;j<numbers.length;j++){
                    if(numbers[j]==target-numbers[i]&&j!=i){
                        results[0] = i+1;
                        results[1] = j+1;
                        return results;
                    }
                }
            }
        }
        return results;
    }
}
