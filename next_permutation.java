import java.util.Arrays;
public class Solution {
    public void nextPermutation(int[] num) {
        if(num.length<=1) return;
        int start = num.length - 1;
        while(start-1>=0){
            if(num[start-1]>=num[start]) start--;
            else break;
        }
        if(start==0){
            Arrays.sort(num, start, num.length);
            return;
        }
        int i = start - 1, j = num.length - 1;
        while(j>start){
            if(num[j]<=num[i]) j--;
            else break;
        }
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
        Arrays.sort(num, start, num.length);
        return;
    }
}
