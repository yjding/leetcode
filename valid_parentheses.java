import java.util.ArrayDeque;
public class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('||c=='{'||c=='[') stack.push(c);
            else{
                if(stack.size()==0) return false;
                if(c==')'&&stack.pop()!='(') return false;
                else if(c=='}'&&stack.pop()!='{') return false;
                else if(c==']'&&stack.pop()!='[') return false;
            } 
        }
        if(stack.size()!=0) return false;
        else return true;
    }
}
