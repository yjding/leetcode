public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length==0||cost.length==0) return -1;
        int total = 0, sum = 0, start = 0;
        for(int i=0;i<gas.length;i++){
            total += gas[i] - cost[i];
            sum += gas[i] -cost[i];
            if(sum<0){
                sum = 0;
                start = i+1;
            }
        }
        if(total<0) return -1;
        else return start;
    }
}
