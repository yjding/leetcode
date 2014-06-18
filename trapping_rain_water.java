public class Solution {
    public int trap(int[] A) {
        int n = A.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for(int i=1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1], A[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1], A[i+1]);
        }
        int sum = 0;
        for(int i=0;i<n;i++){
            int water = Math.min(leftMax[i], rightMax[i]) - A[i];
            if(water>0) sum += water;
        }
        return sum;
    }
}
