public class Solution {
    void sort(int[] A){
        int length = A.length;
        for(int i=0;i<length;i++){
            while(A[i]!=i+1){
                if(A[i]<=0||A[i]>length||A[i]==A[A[i]-1]) break;
                int temp = A[i];
                A[i] = A[A[i]-1];
                A[temp-1] = temp;
            }
        }
    }

    public int firstMissingPositive(int[] A) {
        sort(A);
        for(int i=0;i<A.length;i++){
            if(A[i]!=i+1) return i+1;
        }    
        return A.length+1;
    }
}
