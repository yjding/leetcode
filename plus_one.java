public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length==0) return digits;
        int i = digits.length-1;
        boolean overflow = false;
        do{
            if(digits[i]==9){
                digits[i--] = 0;
                overflow = true;
            }else{
                digits[i--] += 1;
                overflow = false;
            }
        }while(overflow&&i>=0);
        if(i<0&&overflow){
            int[] results = new int[digits.length+1];
            results[0] = 1;
            return results;
        }
        return digits;
    }
}
