public class Solution {
    public int divide(int dividend, int divisor) {
        long a = dividend;
        long b = divisor;
        a = Math.abs(a);
        b = Math.abs(b);
        int sign = 1;
        if(dividend<0) sign = -sign;
        if(divisor<0) sign = -sign;
        
        int res = 0;
        while(a>=b){
            long c = b;
            for(int i=0;a>=c;i++, c=c<<1){
                a -= c;
                res += 1<<i;
            }
        }
        return sign>0?res:-res;
    }
}
