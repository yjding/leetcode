public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[][] table = new boolean[s.length()+1][s.length()+1];
        for(int l=1;l<=s.length();l++){
            for(int i=0;i+l<=s.length();i++){
                if(dict.contains(s.substring(i, i+l))){
                    table[i][i+l] = true;
                    continue;
                }
                for(int k=i+1;k<i+l;k++){
                    if(table[i][k]&&table[k][i+l]){
                        table[i][i+l] = true;
                        break;
                    }
                }
            }
        }
        return table[0][s.length()];
    }
}
