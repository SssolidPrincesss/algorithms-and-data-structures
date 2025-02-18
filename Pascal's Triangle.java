import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri = new ArrayList<>();

        for (int i = 0; i < numRows; i++){
            List<Integer> num = new ArrayList<>(); 
            for (int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    num.add(1);
                }
                else{
                    int temp = tri.get(i-1).get(j-1) + tri.get(i-1).get(j);
                    num.add(temp);
                }
            } 
            tri.add(num);
       } 

        return(tri);
    }
}