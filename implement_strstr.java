public class Solution {
        public String strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if(m==0) return haystack;
        if(n==0) return null;
        int[] T = generateTable(needle);
        int x = 0, k = 0;
        while(x<n-m+1){
            while(k<m&&haystack.charAt(x+k)==needle.charAt(k)) k++;
            if(k==m) return haystack.substring(x);
            else{
                x = x + k - T[k];
                k = T[k]==-1?0:T[k];
            }
        }
        return null;
    }

    public int[] generateTable(String P){
        int m = P.length();
        int[] T = new int[m+1];
        T[0] = -1;
        T[1] = 0;
        int x = 0;
        for(int k=2;k<=m;k++){
            while(x>0&&P.charAt(x)!=P.charAt(k-1)) x = T[x];
            if(P.charAt(x)==P.charAt(k-1)) x++;
            T[k] = x;
        }
        return T;
    }

}
