public class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                if(candies[i-1]>0){
                    candies[i] = candies[i-1] + 1;
                }else{
                    int n = 1 - candies[i-1];
                    candies[i] = 2;
                    candies[i-1] += n;
                    for(int j=i-2;j>=0&&ratings[j]>ratings[j+1];j--){
                        if(candies[j+1]+1>candies[j])
                            candies[j] = candies[j+1] + 1;
                    }
                }
            }
            else if(ratings[i]<ratings[i-1]){
                if(candies[i-1]>1){
                    candies[i] = 1;
                }else{
                    candies[i] = candies[i-1] - 1;
                }
            }
            else{
                if(candies[i-1]>0){
                    candies[i] = 1;
                }else{
                    int n = 1 - candies[i-1];
                    candies[i] = 1;
                    candies[i-1] += n;
                    for(int j=i-2;j>=0&&ratings[j]>ratings[j+1];j--){
                        if(candies[j+1]+1>candies[j])
                            candies[j] = candies[j+1] + 1;
                    }
                }
            }
                
            if(i==ratings.length-1&&candies[i]<=0){
                int n = 1 - candies[i];
                candies[i] += n;
                for(int j=i-1;j>=0&&ratings[j]>ratings[j+1];j--){
                    if(candies[j+1]+1>candies[j])
                            candies[j] = candies[j+1] + 1;
                }
            }
        }
        int sum = 0;
        for(int i=0;i<candies.length;i++){
            sum += candies[i];
        }
        return sum;
    }
}
