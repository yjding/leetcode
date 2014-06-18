public class Solution {
    public int maxArea(int[] height) {
        int i=0, j=height.length-1, water=0;
        while(i<j){
            if(height[i]<=height[j]){
                int tempWater = height[i]*(j-i);
                if(tempWater>water) water = tempWater;
                i++;
            }
            else{
                int tempWater = height[j]*(j-i);
                if(tempWater>water) water = tempWater;
                j--;
            }
        }
        return water;
    }
}
