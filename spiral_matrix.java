public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        if(matrix.length==0||matrix[0].length==0) return results;
        int startX = 0, endX = matrix[0].length - 1, startY = 0, endY = matrix.length - 1;
        while(true){
            //top
            for(int j=startX;j<=endX;j++){
                results.add(matrix[startY][j]);
            }
            if(++startY>endY) break;
            //right
            for(int i=startY;i<=endY;i++){
                results.add(matrix[i][endX]);
            }
            if(startX>--endX) break;
            //bottom
            for(int j=endX;j>=startX;j--){
                results.add(matrix[endY][j]);
            }
            if(startY>--endY) break;
            //left
            for(int i=endY;i>=startY;i--){
                results.add(matrix[i][startX]);
            }
            if(++startX>endX) break;
        }
        return results;
    }
}
