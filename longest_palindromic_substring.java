public class Solution {
    public String longestPalindrome(String s) {
        int slen = s.length();
        boolean[][] table = new boolean[slen][slen];
        int maxStart=0, maxLen = 1, len = 2;
        for(int i=0;i<slen;i++){
            table[i][i] = true;
        }
        for(int i=0;i+len-1<slen;i++){
            int j = i+len-1;
            if(s.charAt(i)==s.charAt(j)){
                maxStart = i;
                maxLen = 2;
                table[i][j] = true;
            }
        }
        for(len=3;len<=slen;len++){
            for(int i=0;i+len-1<slen;i++){
                int j = i+len-1;
                if(s.charAt(i)==s.charAt(j)&&table[i+1][j-1]){
                    maxStart = i;
                    maxLen = len;
                    table[i][j] = true;
                }
            }
        }
        return s.substring(maxStart, maxStart+maxLen);
    }
}
