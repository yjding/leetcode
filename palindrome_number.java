public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length()==0){
            if(s.length()==0) return true;
            else return false;
        }
        else if(p.length()==1){
            if(s.length()==0) return false;
            else{
                if(p.charAt(0)==s.charAt(0)||p.charAt(0)=='.') return isMatch(s.substring(1), p.substring(1));
                else return false;
            }
        }
        else{
            if(p.charAt(1)!='*'){
                if(s.length()==0) return false;
                if(p.charAt(0)=='.'||s.charAt(0)==p.charAt(0)) return isMatch(s.substring(1), p.substring(1));
                else return false;
            }
            else{
                int i=0;
                while(i<s.length()&&(s.charAt(i)==p.charAt(0)||p.charAt(0)=='.')){
                    if(isMatch(s.substring(i+1), p.substring(2))) return true;
                    else i++;
                }
                return isMatch(s, p.substring(2));
            }
        }
    }
}
