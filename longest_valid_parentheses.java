import java.util.ArrayDeque;

public class Solution {
    public int longestValidParentheses(String s) {
        if(s.length()==0) return 0;
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        int maxLen = 0, last = -1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') stack.push(i);
            else{
                if(stack.isEmpty()) last = i;
                else{
                    stack.pop();
                    if(stack.isEmpty()) maxLen = Math.max(maxLen, i-last);
                    else maxLen = Math.max(maxLen, i-stack.peek());
                }
            }
        }
        return maxLen;
    }
}
