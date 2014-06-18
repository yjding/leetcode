public class Solution {
    void recurrGenerateParenthesis(ArrayList<String> results, StringBuilder s, int n, int l, int r){
        if(r==n){
            results.add(s.toString());
            return;
        }
        if(l<n){
            StringBuilder newBuf = new StringBuilder(s);
            recurrGenerateParenthesis(results, newBuf.append('('), n, l+1, r);
        }
        if(r<l){
            StringBuilder newBuf = new StringBuilder(s);
            recurrGenerateParenthesis(results, newBuf.append(')'), n, l, r+1);
        } 
    }
    
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> results = new ArrayList<String>();
        if(n<=0) return results;
        StringBuilder s = new StringBuilder();
        recurrGenerateParenthesis(results, s, n, 0, 0);
        return results;
    }
}
