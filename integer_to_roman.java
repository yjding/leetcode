public class Solution {
    private String[][] list = new String[][]{new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}, 
        new String[]{"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
        new String[]{"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
        new String[]{"M", "MM", "MMM"}};
    
    public String intToRoman(int num) {
        if(num==0) return "";
        int n = 0, x = num;
        while(x/10!=0){
            x /= 10;
            n++;
        }
        return list[n][x-1] + intToRoman(num%(int)Math.pow(10, n));
        
    }
}
