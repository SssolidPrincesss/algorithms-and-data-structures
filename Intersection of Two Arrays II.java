import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        var list  = new ArrayList <Integer>();
        int fCount = 0, sCount = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(fCount < nums1.length && sCount < nums2.length){
            if(nums1[fCount] == nums2[sCount]){
                list.add(nums1[fCount]);
                fCount++;
                sCount++;
            }
          
            else if(nums1[fCount] < nums2[sCount])
            {
                fCount++;
            }
            else
            {
                sCount++;
            }
        }
        return list.stream().mapToInt(x -> x).toArray(); 
    }
}