public class Solution {
    public void sortColors(int[] A) {
        int p=-1, q=A.length, i=0;
        while(i<q){
            if(A[i]==0){
                int temp = A[++p];
                A[p] = A[i];
                A[i] = temp;
                i++;
            }
            else if(A[i]==2){
                int temp = A[--q];
                A[q] = A[i];
                A[i] = temp;
            }
            else{
                i++;
            }
        }
    }
}
