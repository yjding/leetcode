/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Collections;
import java.util.Enumeration;

public class Solution {
    public int maxPoints(Point[] points) {
        if(points.length==0) return 0;
        if(points.length==1) return 1;
        if(points.length==2) return 2;
        int final_max=0;
        for(int i=0;i<points.length;i++){
            int duplicates = 0;
            Hashtable<Double, Integer> slopes = new Hashtable<Double, Integer>();
            for(int j=0;j<points.length;j++){
                int count = 0;
                if(i!=j){
                    if(points[i].x==points[j].x&&points[i].y!=points[j].y){
                       if(slopes.containsKey(Double.MAX_VALUE)){
                            count = slopes.get(Double.MAX_VALUE);
                            slopes.put(Double.MAX_VALUE, count+1);
                        }else{
                            slopes.put(Double.MAX_VALUE, 1);
                        }
                    }
                    else if(points[i].x==points[j].x&&points[i].y==points[j].y)
                        duplicates += 1;
                    else{
                        Double k = (points[i].y - points[j].y)/(double)(points[i].x - points[j].x);
                        if(slopes.containsKey(k)){
                            count = slopes.get(k);
                            slopes.put(k, count+1);
                        }else{
                            slopes.put(k, 1);
                        }
                    }
                }
            }
            int max = 0;
            Enumeration elements = slopes.elements();
            int temp_count = 0;
            while(elements.hasMoreElements()){
                temp_count = (int)elements.nextElement();
                if(temp_count>max)
                    max = temp_count;
            }
            max = max + duplicates + 1;
            if(max>final_max){
                final_max = max;
            }
        }
        return final_max;
    }
}
