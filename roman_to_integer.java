import java.util.Hashtable;
public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);
        int i = 0;
        while(i<s.length()){
            if(i+1>=s.length()){
                result += table.get(s.charAt(i));
                break;
            }
            else{
                if(table.get(s.charAt(i))>=table.get(s.charAt(i+1))){
                    result += table.get(s.charAt(i));
                    i++;
                }
                else{
                    result += table.get(s.charAt(i+1)) - table.get(s.charAt(i));
                    i += 2;
                }
            }
        }
        return result;
    }
}
