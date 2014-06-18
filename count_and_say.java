public class Solution {
    String convert(String sequence){
        int length = sequence.length();
        StringBuffer buffer = new StringBuffer();
        int i = 0;
        while(i<length){
            char c = sequence.charAt(i);
            int j = 1;
            while(i+j<length&&sequence.charAt(i+j)==c) j++;
            buffer.append(j);
            buffer.append(c);
            i += j;
        }
        return buffer.toString();
    }
    
    public String countAndSay(int n) {
        String input = "1";
        for(int i=0;i<n-1;i++){
            input = convert(input);
        }
        return input;
    }
}
