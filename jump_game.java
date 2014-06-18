public class Solution {
    public boolean canJump(int[] A) {
        int currentIndex = 0, length = A.length;
        while(currentIndex<length){
            if(A[currentIndex]==0){
                if(currentIndex>=length-1) return true;
                else return false;
            }
            int nextStep = 0;
            for(int i=1;i<=A[currentIndex];i++){
                if(currentIndex+i>length-1) return true;
                if(i+A[currentIndex+i]>nextStep)
                    nextStep = i + A[currentIndex+i];
            }
            currentIndex += nextStep;
        }
        return true;
    }
}
