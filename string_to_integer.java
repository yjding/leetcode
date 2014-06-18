public class Solution {
    public int atoi(String str) {
        if(str.length()==0) return 0;
        int start=0, end=0, i=0;
        boolean minus = false;
        for(;i<str.length();i++){
            char c = str.charAt(i);
            if(c==' '){
                continue;
            }
            else{
                start = i;
                break;
            }
        }
        if(i>=str.length()) return 0;
        if(str.charAt(i)=='-'){
            minus = true;
            start = ++i;
        }
        if(str.charAt(i)=='+'){
            start = ++i;
        }
        if(str.charAt(i)<'0'||str.charAt(i)>'9') return 0;
        for(;i<str.length();i++){
            char c = str.charAt(i);
            if(c<'0'||c>'9'){
                end = i;
                break;
            }
        }
        if(i>=str.length()) end = i;
        if(start>=end) return 0;
        String input = str.substring(start, end);
        int result = 0;
        for(int j=0;j<input.length();j++){
            char c = input.charAt(j);
            result = result*10 + (c-'0');
        }
        if((input.length()>10||result<0)&&minus) return Integer.MIN_VALUE;
        if((input.length()>10||result<0)&&!minus) return Integer.MAX_VALUE;
        if(minus) result = -result;
        return result;
    }
}
