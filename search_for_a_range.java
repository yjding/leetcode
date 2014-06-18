public class Solution {
    int searchLeft(int[] A, int start, int end, int target){
        if(start>end) return -1;
        int mid = (start + end)/2;
        if(start==end){
            if(A[mid]==target) return mid;
            else return -1;
        }
        if(A[mid]<target) return searchLeft(A, mid+1, end, target);
        else{
            int index = searchLeft(A, start, mid, target);
            if(index==-1) return mid;
            else return index;
        }
    }

    int searchRight(int[] A, int start, int end, int target){
        if(start>end) return -1;
        int mid = (start + end)/2;
        if(start==end){
            if(A[mid]==target) return mid;
            else return -1;
        }
        if(A[mid]>target) return searchRight(A, start, mid, target);
        else{
            int index = searchRight(A, mid+1, end, target);
            if(index==-1) return mid;
            else return index;
        }
    }

    public int[] searchRange(int[] A, int target) {
        int start = 0, end = A.length - 1, midIndex = 0;
        while(start<=end){
            int mid = (start + end)/2;
            if(start==end){
                if(A[mid]==target){
                    midIndex = mid;
                    break;
                }else{
                    midIndex = -1;
                    break;
                }
            }
            if(A[mid]==target){
                midIndex = mid;
                break;
            }
            else if(A[mid]<target){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        if(midIndex==-1) return new int[]{-1, -1};
        else{
            int leftIndex = searchLeft(A, 0, midIndex, target);
            int rightIndex = searchRight(A, midIndex+1, A.length-1, target);
            return new int[]{leftIndex==-1?midIndex:leftIndex, rightIndex==-1?midIndex:rightIndex};
        }
    }
}
