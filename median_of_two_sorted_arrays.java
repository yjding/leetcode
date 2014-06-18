public class Solution {
    public int findKth(int A[], int B[], int aStart, int aEnd, int bStart, int bEnd, int k){
        int m = aEnd-aStart+1, n = bEnd-bStart+1;
        // special cases
        if(m==0) return B[bStart+k];
        if(n==0) return A[aStart+k];
        if(k==0) return A[aStart]<B[bStart]?A[aStart]:B[bStart];
        
        int i = m*k/(m+n), j = k-1-i;
        i += aStart;
        j += bStart;
        if(A[i]>B[j]) return findKth(A, B, aStart, i, j+1, bEnd, k-j+bStart-1);
        else return findKth(A, B, i+1, aEnd, bStart, j, k-i+aStart-1);
    }
    
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;
        return (m+n)%2==0?(findKth(A, B, 0, m-1, 0, n-1, (m+n)/2-1)+findKth(A, B, 0, m-1, 0, n-1, (m+n)/2))*0.5:(double)findKth(A, B, 0, m-1, 0, n-1, (m+n)/2);
    }
}
