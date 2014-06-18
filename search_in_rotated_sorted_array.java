public class Solution {
    int searchSorted(int[] A, int start, int end, int target){
        int mid = (start+end)/2;
        if(target==A[mid]) return mid;
        else if(start==end) return -1;
        else if(target<A[mid]) return searchSorted(A, start, mid, target);
        else return searchSorted(A, mid+1, end, target);
    }

    int searchNotSorted(int[] A, int start, int end, int target){
        int mid = (start+end)/2;
        if(target==A[mid]) return mid;
        else if(start==end) return -1;
        else if(A[start]<=A[mid]){
            if(target>=A[start]&&target<=A[mid]) return searchSorted(A, start, mid, target);
            else return searchNotSorted(A, mid+1, end, target);
        }
        else{
            if(target>=A[mid]&&target<=A[end]) return searchSorted(A, mid, end, target);
            else return searchNotSorted(A, start, mid, target);
        }
    }

    public int search(int[] A, int target) {
        return searchNotSorted(A, 0, A.length-1, target);
    }
}
