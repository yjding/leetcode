public class Solution {
    public int removeElement(int[] A, int elem) {
        int length = A.length, lastIndex=length-1;
        if(length==0) return 0;
        while(lastIndex>=0&&A[lastIndex]==elem) lastIndex--;
        for(int i=0;i<lastIndex;i++){
            if(A[i]==elem){
                A[i] = A[lastIndex--];
                while(lastIndex>=0&&A[lastIndex]==elem) lastIndex--;
            }
        }
        return lastIndex+1;
    }
}
