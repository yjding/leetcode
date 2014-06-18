public class Solution {
    int[] makeIntArray(String num){
        int size = num.length();
        if(size==0) return new int[]{0};
        int[] result = new int[size];
        for(int i=size-1;i>=0;i--){
            result[size-i-1] = num.charAt(i)-'0';
        }
        return result;
    }

    int[] multiplyIntArray(int[] x, int[] y){
        int[] z = new int[x.length*y.length+1];
        for(int i=0;i<x.length;i++){
            for(int j=0;j<y.length;j++){
                z[i+j] += x[i]*y[j];
                z[i+j+1] += z[i+j]/10;
                z[i+j] = z[i+j]%10;
            }
        }
        return z;
    }

    String convertToString(int[] num){
        StringBuilder buffer = new StringBuilder();
        int i = num.length - 1;
        while(i>0&&num[i]==0) i--;
        while(i>=0) buffer.append(num[i--]);
        return buffer.toString();
    }

    public String multiply(String num1, String num2) {
        return convertToString(multiplyIntArray(makeIntArray(num1), makeIntArray(num2)));
    }
}
