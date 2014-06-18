import java.util.ArrayList;

public class Solution {
    public String convert(String s, int nRows) {
        ArrayList<ArrayList<Character>> zigzag = new ArrayList<ArrayList<Character>>();
        for(int i=0;i<nRows;i++){
            zigzag.add(new ArrayList<Character>());
        }
        int k=0;
        boolean increase = true;
        for(int j=0;j<s.length();j++){
            zigzag.get(k).add(s.charAt(j));
            if(k>=nRows-1){
                k = (nRows - 2)>=0?nRows-2:0;
                increase = false;
            }
            else if(k<=0){
                k = 1>(nRows-1)?nRows-1:1;
                increase = true;
            }
            else{
                if(increase) k++;
                else k--;
            }
        }
        StringBuilder buffer = new StringBuilder();
        for(int i=0;i<zigzag.size();i++){
            ArrayList<Character> row = zigzag.get(i);
            for(int j=0;j<row.size();j++){
                buffer.append(row.get(j));
            }
        }
        return buffer.toString();
    }
}
