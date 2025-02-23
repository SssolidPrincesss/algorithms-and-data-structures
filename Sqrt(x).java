class Solution {
    public int mySqrt(int x) {
		var result = 0L;
        for(var i = 1L; i*i  <= x; i++){
            if(i*i <= x){
                result = i;
            }else{
                break;
            }
        }
        return (int)result;
    }
}