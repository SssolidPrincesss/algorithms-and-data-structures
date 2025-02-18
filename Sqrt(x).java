class Solution {
    public int mySqrt(int x) {
		int var = 0;
        for(int i = 1; i*i  <= x*x; i++){
            int z = i*i;
            int y = (i+1)*(i+1);
            if(z <= x){
            	if(x - z <= y - x) {
            		var = i;
            	}
            	else {
            		var = i;
            	}
            }
        }
        return var;
    }
}