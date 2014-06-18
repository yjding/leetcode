public class Solution {
    public int jump(int[] A) {
        if(A.length<=1) return 0;
        int currentIndex = 0;
        int steps = 0;
        int lastIndex = A.length-1;
        while(currentIndex+A[currentIndex]<lastIndex){
            int nextIndex = currentIndex + 1;
            int maxSteps = 0;
            for(int i=1;i<=A[currentIndex];i++){
                if(i+A[currentIndex+i]>=maxSteps){
                    nextIndex = currentIndex + i;
                    maxSteps = i + A[currentIndex+i];
                }
            }
            //Jump
            currentIndex = nextIndex;
            steps++;
        }
        if(currentIndex==lastIndex) return steps;
        else return steps+1;
    }
}
