import java.util.Arrays;
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if(num.length<3) return 0;
        int sum = 2000000000;
        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++){
            int newTarget = target - num[i];
            int j=i+1, k=num.length-1;
            while(j<k){
                if(Math.abs(newTarget-num[j]-num[k])<Math.abs(target-sum)){
                    sum = num[i]+num[j]+num[k];
                }
                if(num[j]+num[k]>newTarget) k--;
                else if(num[j]+num[k]<newTarget) j++;
                else return target;
            }
        }
        return sum;
    }
}
