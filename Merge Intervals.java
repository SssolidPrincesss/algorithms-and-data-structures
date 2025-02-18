import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        var rez = new ArrayList<int[]>();

        for(var arr : intervals){
            
            if(rez.isEmpty() || rez.getLast()[1] < arr[0]){
                rez.add(arr);
            } 
            else{
                rez.getLast()[1] = Math.max(rez.getLast()[1], arr[1]);
            }
        }
        return rez.toArray(int[][]::new);
    }
}
