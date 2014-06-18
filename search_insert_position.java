public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A.length==0) return 0;
        int start = 0, end = A.length - 1;
        while(start<=end){
            int mid = (start + end)/2;
            if(start==end){
                if(target==A[mid]) return mid;
                else if(target<A[mid]) return mid;
                else return mid+1;
            }
            if(target==A[mid]) return mid;
            else if(target<A[mid]) end = mid;
            else start = mid + 1;
        }
        return -1;
    }
}
