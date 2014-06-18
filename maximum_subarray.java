public class Solution {
    public int maxSubArray(int[] A) {
        int maxSum = 0;
        int sum = 0;
        for(int i=0;i<A.length;i++){
            if(sum+A[i]<0){
                sum = 0;
            }
            else sum += A[i];
            if(sum>maxSum) maxSum = sum;
        }
        if(maxSum==0){
            int max = A[0];
            for(int i=1;i<A.length;i++){
                if(A[i]>max) max = A[i];
            }
            return max;
        }
        else return maxSum;
    }
}

