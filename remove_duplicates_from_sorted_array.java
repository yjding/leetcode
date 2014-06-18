public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length==0) return 0;
        int lastElem=A[0], lastIndex=0;
        for(int i=1;i<A.length;i++){
            if(A[i]==lastElem) continue;
            else{
                A[++lastIndex] = A[i];
                lastElem = A[i];
            }
        }
        return lastIndex+1;
    }
}
